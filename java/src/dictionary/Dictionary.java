package dictionary;
import java.util.ArrayList;

public class Dictionary {
    public ArrayList<Word> words;

    public Dictionary() {
        this.words = new ArrayList<Word>();
    }

    public void addWords(String target, String explain) {
        Word word = new Word();
        word.setWordTarget(target);
        word.setWordExpain(explain);
        words.add(word);
    }

    public Word search(String filter) {
        for(int i = 0; i < words.size(); i++) {
            if(getWord(i).getWordTarget().equals(filter)) {
                return getWord(i);
            }
        }
        return null;
    }

    public void remove(String filter) {
        words.remove(search(filter));
    }

    public void modify(String target, String explain) {
        search(target).setWordExpain(explain);
    }

    public Word getWord(int i) {
        return words.get(i);
    }
}
