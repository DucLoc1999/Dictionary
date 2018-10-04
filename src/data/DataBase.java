
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class DataBase{
    private final String FILE_PATH = "AnhViet.txt";
    private ArrayList<Word> DictData = new ArrayList<Word>();
    private Map<Integer, String> wordTarget_ = new HashMap();
    private Map<Integer, String> wordInfo_ = new HashMap<>();

    public String getFILE_PATH() {
        return FILE_PATH;
    }

    public DataBase(){
         //this.readFile(FILE_PATH);

    }
    
    //finding position of a word if dictionary has it or the position of the word front of it
    int findPosition(String w){
        int n = this.getData().size() - 1;
        int i = 0;
        
        if(w.compareTo(this.getData().get(0).getWord_target()) <= 0)
            return 0;
        
        while(i < n){
            if(w.compareTo(this.getData().get(n).getWord_target()) == 0)
                return n;
            
            if(w.compareTo(this.getData().get(n).getWord_target()) > 0)
                return n+1;//find "e" in "a", "b", "d" will return 4 pos after "d"
            
            Word w1 = this.getData().get((i + n)/2);
            int compare = w.compareTo(w1.getWord_target());

            if(compare == 0){
                return (i+n)/2;
                
            }else if(compare > 0){
                i = (i+n)/2 + 1;
                n --;
            } else {
                n = (i+n)/2;
            }
        }
        if(w.compareTo(this.getData().get(i).getWord_target()) > 0)
            return i+1;//find "c" in "a", "b", "d" will return 2 pos of "d"
        return i;
    }
    

    ///useless
    void addWord(String word, String info){
        this.addWord(new Word(word, info));
    }

    //add word into dictionary if it doesn't have
    boolean addWord(Word word){
        int i = this.findPosition(word.word_target);

        if(this.DictData.size() == 0 || this.DictData.get(i).compareTo(word) != 0){
            this.DictData.add(i,word);
            return true;
        } else
            return false;
    }

    //remove word from dictionary if it has
    boolean removeWord(Word word){
        if(this.DictData.remove(word))
            return true;

        if(this.DictData.size() == 0)
            return false;

        int i = this.findPosition(word.word_target);

        if(this.DictData.get(i).compareTo(word) == 0){
            this.DictData.remove(i);
            return true;
        } else
            return false;
    }

    //make change in word's info
    void changeWordInfo(Word word, String info){
        word.setWord_info(info);
    }

    public void readFile(String filePath){
        String line;
        try{
            BufferedReader reader = new BufferedReader(new FileReader(filePath));


            while((line = reader.readLine()) != null){
                String word = "";
                String info;
                char[] a = line.toCharArray();

                int i = 0;
                while(a[i] != '<'){
                    word += a[i];
                    i++;
                }
                info = line.substring(i);
                this.DictData.add(new Word(word, info));
            }
        }catch (Exception e){
            System.out.println(this.DictData.size());
            System.out.println("Can't read file:" + filePath);
        }
        System.out.println(this.getDictData().size());
    }

    public ArrayList<Word> getDictData() {
        return DictData;
    }

    public Map getWordTarget_(){
        try {
            for(int i = 0; i < DictData.size(); i ++){
                wordTarget_.put(i , DictData.get(i).getWord_target());
            }

        }catch (Exception e){
            System.out.println("Can't get Word!!!!!");
        }
        return wordTarget_;
    }
    public Map getWordInfo_(){
        try {
            for(int i = 0; i < DictData.size(); i ++){
                wordInfo_.put(i , DictData.get(i).getWord_info());
            }

        }catch (Exception e){
            System.out.println("Can't get info  Word!!!!!");
        }
        return wordInfo_;
    }



}
