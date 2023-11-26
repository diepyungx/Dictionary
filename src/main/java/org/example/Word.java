package org.example;

public class Word {
    private  String word_target;
    private String word_explain;

    public Word() {
    }

    public Word (String word_target, String word_explain) {
        this.word_target = word_target;
        this.word_explain = word_explain;
    }
    //TO DO : khai bao phuong thuc getter setter
    /**
     * getWord_target.
     */
    public String getWord_target() {
        return word_target;
    }

    /**
     * getWord_explain.
     */
    public String getWord_explain() {
        return word_explain;
    }

    /**
     * setWord_target.
     */
    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    /**
     * setWord_explain.
     */
    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public int compare(Word w1, Word w2) {
        return  (w1.getWord_target().compareTo(w2.getWord_target()));
    }
}
