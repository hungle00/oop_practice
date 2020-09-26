package dictionary;

public class Word {
    private String wordTarget, wordExplain;
    
    public Word() {

    }
    
    public Word(String wordTarget, String wordExplain) {
        this.wordTarget = wordTarget;
        this.wordExplain = wordExplain;
    }
    
    public String getWordTarget() {
        return this.wordTarget;
    }

    public String getWordExpain() {
        return this.wordExplain;
    }

    public void setWordTarget(String wordTarget) {
        this.wordTarget = wordTarget;
    }

    public void setWordExpain(String wordExplain) {
        this.wordExplain = wordExplain;
    }

    public String toString(){//overriding the toString() method  
        return wordTarget+ "    "+ wordExplain;  
    }

    public boolean match(String filter) {
        return filter == getWordTarget();
    }

    public static void main(String args[]) {
        Word hello = new Word("hello", "chao");
        System.out.println(hello.match("chao"));
        //System.out.println(hello.getWordTarget() == "hello");
    }

}
