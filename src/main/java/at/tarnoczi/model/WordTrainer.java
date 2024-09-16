package at.tarnoczi.model;

import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Random;

/**
 * WordTrainer-Klasse
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class WordTrainer {
    private List<Word> words;
    private int total;
    private int correct;
    private int currentIndex;
    private JSONStorage storage = new JSONStorage();

    public WordTrainer() {
        this.storage.load(this);
        this.currentIndex = new Random().nextInt(words.size());
    }

    public void setWords(List<Word> words) throws IllegalArgumentException {
        if(words == null ||words.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.words = words;
    }

    public List<Word> getWords() {
        return words;
    }

    public int getCorrect() {
        return correct;
    }

    public void setCorrect(int correct) throws IllegalArgumentException {
        if (correct < 0) {
            throw new IllegalArgumentException();
        }
        this.correct = correct;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) throws IllegalArgumentException {
        if (total < 0) {
            throw new IllegalArgumentException();
        }
        this.total = total;
    }

    public void store() {
        this.storage.store(this);
    }
    public void load() {
        this.storage.load(this);
    }

    public Word getCurrentWord() {
        return words.get(currentIndex);
    }

    public boolean check(String input) {
        return input.toLowerCase().equals(getCurrentWord().getWord().toLowerCase());
    }
}
