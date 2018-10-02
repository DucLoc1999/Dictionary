/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary;

import com.sun.speech.freetts.*;


/**
 *using freeTTS
 *voice: kevin16
 */

public class textSpeech {
    static private final String  voiceName = "kevin16";
    static public void speak(String text){
            try {
                VoiceManager voiceManager = VoiceManager.getInstance();
                Voice voice = voiceManager.getVoice(voiceName);
                voice.allocate();//ready to speak: creates an audio output.
                voice.speak(text);
                voice.deallocate();//Shuts down the voice processing.
        } catch(Exception e) {
        e.printStackTrace();
        }
    }

}
