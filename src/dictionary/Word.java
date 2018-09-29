package dictionary;

/**
 *
 * @author SONY
 */
public class Word implements Comparable{
    String word_target;
    String pronounce; 
    String word_explain = new String();
    
    Word(String word, String pronounce, String info){
        this.word_target = word;
        this.pronounce = pronounce;
        this.word_explain = info;
    }
    
    void setInfo(String s){
        this.word_explain = s;
    }
    
    void print(){
        System.out.println(this.word_target + " " + this.pronounce + "\n" + this.word_explain);
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
