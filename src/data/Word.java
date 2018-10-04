public class Word implements Comparable{
    String word_target;
    String word_info;

    public String getWord_info() {
        return word_info;
    }

    public void setWord_info(String word_info) {
        this.word_info = word_info;
    }

    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    Word(String word, String info){
        this.word_target = word;
        this.word_info = info;
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