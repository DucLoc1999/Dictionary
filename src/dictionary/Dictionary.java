package dictionary;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;

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
    
    int findPosion(String w){
        int n = this.DictData.size() - 1;
        int i = 0;
        
        if(w.compareTo(this.DictData.get(0).word_target) <= 0)
            return 0;
            
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
    
    void addWord(String word, String info){
        
    }
    
    void addWord(Word word){
        this.DictData.add(word);
    }
    
    void deleteWord(){
        
    }
    
    void changeWordInfo(){
        
    }
    
    void print(){
        for(Word w : this.DictData)
            w.print();
    }
}
    
        
public class Dictionary {

    
    public static void main(String[] args) {
        DictionaryManagement d = new DictionaryManagement();
        d.addWord(new Word("a",""));
        d.addWord(new Word("b",""));
        d.addWord(new Word("c",""));
        
        d.print();
        System.out.println(("A").compareTo("a"));
    }
    
}
