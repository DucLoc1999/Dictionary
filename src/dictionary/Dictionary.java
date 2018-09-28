package dictionary;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Scanner;

class Word implements Comparable{
    String word_target;
    String word_explain = new String();
    
    Word(String word,String info){
        this.word_target = word;
        this.word_explain = info;
    }
    
    void setInfo(String s){
        this.word_explain = s;
    }
    
    void print(){
        System.out.println(this.word_target+ "\n" + this.word_explain);
    }
    
    public boolean equals(Word w){
        return this.word_target.equals(w.word_target);
    }
    
    @Override
    public int compareTo(Object t) {
        Word w = (Word) t;
        return (this.word_target).compareTo(w.word_target);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

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
    void addWord(String word, String info){
        this.addWord(new Word(word,info));
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
    
    //
    
}
    
        
public class Dictionary {

    
    public static void main(String[] args) {
        DictionaryManagement d = new DictionaryManagement();
        if(d.addWord(new Word("a","")))
            System.out.println("can a 1");
        if(d.addWord(new Word("ab","")))
            System.out.println("can ab 2");
        if(d.addWord(new Word("a","")))
            System.out.println("can a 3");
        if(d.addWord(new Word("Aa","")))
            System.out.println("can Aa 3");
        
        if(d.removeWord(new Word("Aa","")))
            System.out.println("xoa Aa 3");
        
        d.print();
        Word a = new Word("a","");
        Word b = new Word("aa","");
        Word c = new Word("ab","");
        Scanner scan = new Scanner(System.in);
        try{
            
            System.out.println(Translator.translate("en", "vi", scan.nextLine()));
            
        } catch(Exception e) {
            System.out.println("can't translate");
            e.printStackTrace();
        } finally {
            Translator.disconnect();
        }
        
    }
    
}
