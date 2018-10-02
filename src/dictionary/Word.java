package dictionary;

/**
 *
 * @author SONY
 */
public class Word implements Comparable{
    private String word_target;
    private String pronounce; 
    private String word_explain;

    public String getWord_target() {return word_target;}

    public void setWord_target(String word_target) {this.word_target = word_target;}

    public String getPronounce() {return pronounce;}

    public void setPronounce(String pronounce) {this.pronounce = pronounce;}

    public String getWord_explain() {return word_explain;}

    public void setWord_explain(String word_explain) {this.word_explain = word_explain;}
    
    Word(String word, String pronounce, String info){
        this.word_target = word;
        this.pronounce = pronounce;
        this.word_explain = info;
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

    public int compareTo(String w) {
        return (this.word_target).compareTo(w);
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
