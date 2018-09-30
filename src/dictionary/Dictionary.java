package dictionary;
import static dictionary.ApiKeys.YANDEX_API_KEY;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


class DictionaryManagement{
    private ArrayList<Word> DictData = new ArrayList<Word>();
    
    //finding position of a word if dictionary has it or the position of the word front of it
    int findPosition(String w){
        int n = this.DictData.size() - 1;
        int i = 0;
        try{
        if(w.compareTo(this.DictData.get(0).word_target) <= 0)
            return 0;
        }catch(Exception e){
            return 0;
        }
        
        while(i < n){
            Word w1 = this.DictData.get((i + n)/2);
            int compare = w.compareTo(w1.word_target);
            
            if(w.compareTo(this.DictData.get(n).word_target) >= 0)
                return n;
            if(compare == 0){
                return (i+n)/2;
            }else if(compare > 0){
                i = (i+n)/2;
                n --;
            } else {
                n = (i+n)/2;
            }
        }
        return i;
    }
    
    ///useless
    void addWord(String word, String pronounce, String info){
        this.addWord(new Word(word, pronounce, info));
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
        word.setInfo(info);
    }
    
    // print out word and it's info
    void print(){
        for(Word w : this.DictData)
            w.print();
    }
    //useless
    void print(int tt){
        Word w = this.DictData.get(tt);
        if(w != null)
            w.print();
    }
    //
    public void readFile(String filePath){

        String line;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while ((line = reader.readLine()) != null)//lấy đến hết
            {
                line = (line.substring(1, line.length()- 1)); // bỏ pt @ đầu chữ
                String[] w = line.split("/");// tách phần phát âm ra
                int i = 0;
                String word = "";
                String pronounce ="";
                for(String s : w){
                    if(i == 0)
                        word += s.substring(0, s.length() - 1);//xếp phần chữ lại
                    else
                        pronounce += "/" + s;//xếp phần phát âm lại
                    i++;
                }
                pronounce += "/";
                
                String explain = "" + reader.readLine();
                while(!"".equals(line = reader.readLine())){// "" là dòng giữa các từ khác nhau lấy hết phần info của từ trước dòng này
                    explain += "\n" + line;
                }
                this.DictData.add(new Word(word, pronounce, explain));
                
            }
        } catch (Exception e) {
            System.out.println(this.DictData.size());
            System.out.println("can't read file: " + filePath);
        }
    }

    public ArrayList<Word> getDictData() {
        return DictData;
    }
    
}
    
        
public class Dictionary {

    
    public static void main(String[] args) throws Exception {
        DictionaryManagement dict = new DictionaryManagement();
        dict.readFile("./AnhViet.txt");
        Scanner scan = new Scanner(System.in);
        String input = " ";
        // "#ok close" lệnh tạm thời để dừng chương trình
        while(!"#ok close".equals(input = scan.nextLine())){
            
            int pos = dict.findPosition(input);
            
            if(pos < dict.getDictData().size() && dict.getDictData().get(pos).compareTo(input) == 0)
                dict.print(pos);
            else{
                try {
                    Translate.setKey(YANDEX_API_KEY);
                    //if(Detect.execute(input).compareTo(Language.ENGLISH) == 0)
                    System.out.println(Translate.execute(input, Language.ENGLISH, Language.VIETNAM));
                    //else
                    //    System.out.println("ERROR: input is not English language");
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        
    }
    
}
