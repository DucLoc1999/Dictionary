package dictionary;
import static dictionary.ApiKeys.YANDEX_API_KEY;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

class DictionaryManagement{
    private ArrayList<Word> DictionaryData = new ArrayList<>();
    
    public ArrayList<Word> getData() {
        return DictionaryData;
    }
    
    //finding position of a word if dictionary has it or the position of the word front of it
    int findPosition(String w){
        int n = this.getData().size() - 1;
        int i = 0;
        try{
        if(w.compareTo(this.getData().get(0).getWord_target()) <= 0)
            return 0;
        }catch(Exception e){
            return 0;
        }
        
        while(i < n){
            Word w1 = this.getData().get((i + n)/2);
            int compare = w.compareTo(w1.getWord_target());
            
            if(w.compareTo(this.getData().get(n).getWord_target()) > 0)
                return n+1;
            
            if(compare == 0){
                return (i+n)/2;
                
            }else if(compare > 0){
                i = (i+n)/2 + 1;
                n --;
            } else {
                n = (i+n)/2;
            }
        }
        return i;
    }
    
    ///useless
    void addWord(String word, String pronounce, String info){
        this.DictionaryData.add(new Word(word, pronounce, info));
    }
    
    //add word into dictionary if it doesn't have
    boolean addWord(Word word){

        if(this.getData().isEmpty()){
            this.DictionaryData.add(word);
            return true;
        }

        int i = this.findPosition(word.getWord_target());            
        if(this.DictionaryData.get(i).compareTo(word) != 0){
            this.DictionaryData.add(i,word);
            return true;
        }
        
        return false;
    }
    
    //remove word from dictionary if it has
    boolean removeWord(Word word){
        if(this.DictionaryData.remove(word))
            return true;
                
        if(this.DictionaryData.isEmpty())
            return false;
            
        int i = this.findPosition(word.getWord_target());
        
        if(this.DictionaryData.get(i).compareTo(word) == 0){
            this.DictionaryData.remove(i);
            return true;
        } else
            return false;
    }
    
    // print out word and it's info
    void print(){
        for(Word w : this.DictionaryData)
            w.print();
    }
    
    //useless
    void print(int tt){
        Word w = this.DictionaryData.get(tt);
        if(w != null)
            w.print();
    }
    //
    public void readFile(String filePath){
        String line;
        try  {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            reader.readLine();
            while ((line = reader.readLine()) != null){//lấy đến hết
                String[] w = line.split("/");// tách phần phát âm ra
                String word = "";
                String pronounce ="";
                word += w[0].substring(0, w[0].length() - 1);//xếp phần chữ lại
                for(int i = 1; i < w.length; i++){
                        pronounce += "/" + w[i];//xếp phần phát âm lại
                }
                pronounce += "/";
                
                String explain = "" + reader.readLine();
                // "" là dòng giữa các từ khác nhau lấy hết phần info của từ trước dòng này
                while((line = reader.readLine())!= null && !line.equals("")){
                    explain += "\n" + line;
                }
                
                this.DictionaryData.add(new Word(word, pronounce, explain));
                //this.DictionaryData.get(this.DictionaryData.size()-1).print();
                
            }
        } catch (Exception e) {
            System.out.println(this.DictionaryData.size());
            System.out.println("can't read file: " + filePath);
        }
    }

    
}
    
        
public class Dictionary {

    
    public static void main(String[] args) throws Exception {
        DictionaryManagement dict = new DictionaryManagement();
        dict.readFile("./AnhViet1.txt");
        
        Scanner scan = new Scanner(System.in);
        String input = "";
        
        // "#c" lệnh tạm thời để dừng chương trình
        /*while(!"#c".equals(input = scan.nextLine())){
            
            int pos = dict.findPosition(input);
            System.out.print(pos +":  ");
            if(dict.getData().get(pos).compareTo(input) == 0)
                dict.print(pos);
            else{
                System.out.println(dict.getData().get(pos).getWord_target());
           //     try {
             //       Translate.setKey(YANDEX_API_KEY);
                    //if(Detect.execute(input).compareTo(Language.ENGLISH) == 0)
               //     System.out.println(Translate.execute(input, Language.ENGLISH, Language.VIETNAM));
                    //else
                    //    System.out.println("ERROR: input is not English language");
                //} catch (Exception e) {
                    // TODO Auto-generated catch block
                  //  e.printStackTrace();
                //}
                
            }
        }*/
        
        
        
        System.out.println(dict.getData().size());
        int a;
        while(123 != (a = scan.nextInt())){
            dict.getData().get(a).print();
            }
          
        
        
        /**
         * text to speech
         */
        /*
        while(!("stop").equals(input)){
            input = scan.nextLine();
            textSpeech.speak(input);
        }*/
    }
    
}
