package dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Translator {
    // TODO: If you have your own Premium account credentials, put them down here:
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "http://api.whatsmate.net/v1/translation/translate";
    private static boolean hasConnect = false;
    private static HttpURLConnection conn = null;
    
    /**
     * set up connection to WhatsMate WA Gateway
     * @throws Exception
     */
    public static void establishConnection(){
        try{
        URL url = new URL(ENDPOINT);
        conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("POST");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        conn.setRequestProperty("Content-Type", "application/json");
        } catch (IOException e){
            System.out.println("can't connect to WhatsMate WA Gateway");
        }
    }
    
    /**
     * disconnect the connection
     */
    public static void disconnect(){
        hasConnect = false;
        conn.disconnect();
    }
    
    /**
     * Sends out a WhatsApp message via WhatsMate WA Gateway.
     */
    public static String translate(String fromLang, String toLang, String text) throws Exception {
        if(! hasConnect)
            establishConnection();
        
        // TODO: Should have used a 3rd party library to make a JSON string from an object
        String jsonPayload = new StringBuilder()
        .append("{\"fromLang\":\"" + fromLang + "\",\"toLang\":\""+ toLang + "\",\"text\":\"" + text + "\"}").toString();
                //{"fromLang":"<ngôn ngữ cần được dịch>","toLang":"<ngôn ngữ dịch thành>","text":"<văn bản cần dịch>

        OutputStream os = conn.getOutputStream();
        if(os == null)
        {
            System.out.println("lost connection");
            return "";
        }
        os.write(jsonPayload.getBytes());
        os.flush();
        os.close();

        int statusCode = conn.getResponseCode();
        //System.out.println(statusCode);
        if(statusCode == 470)
            return "";
        else {
            BufferedReader br = new BufferedReader(new InputStreamReader( (statusCode == 200) ? conn.getInputStream() : conn.getErrorStream() ));
            String output = "";
            String line;
            while ((line = br.readLine()) != null) {
                output += line;
            }
            return output;
        }
    }

    /**
     * Entry Point
     */
    public static void main(String[] args) throws Exception {
        // TODO: Specify your translation requirements here:
        String fromLang = "en";
        String toLang = "vi";
        String text = args[0];

        Translator.translate(fromLang, toLang, text);
    }

}
