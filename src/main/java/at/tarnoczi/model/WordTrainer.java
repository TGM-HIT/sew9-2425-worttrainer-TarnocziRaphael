package at.tarnoczi.model;

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
    private StrategyStorage storage = new JSONStorage();

    /**
     * constructor
     */
    public WordTrainer() {
        this.storage.load(this);
        this.currentIndex = new Random().nextInt(words.size());
    }

    /**
     * setter-method for the attribute words
     * @param words the new value of the attribute words
     * @throws IllegalArgumentException is thrown if the parameter is null or an empty list
     */
    public void setWords(List<Word> words) throws IllegalArgumentException {
        if(words == null ||words.size() == 0) {
            throw new IllegalArgumentException();
        }
        this.words = words;
    }

    /**
     * getter-method for the attribute words
     * @return the value of the attribute words
     */
    public List<Word> getWords() {
        return words;
    }

    /**
     * getter-Method for the attribute correct
     * @return the value of the attribute correct
     */
    public int getCorrect() {
        return correct;
    }

    /**
     * setter-method for the attribute correct
     * @param correct the new value for the attribute correct
     * @throws IllegalArgumentException is thrown if correct is negative
     */
    public void setCorrect(int correct) throws IllegalArgumentException {
        if (correct < 0) {
            throw new IllegalArgumentException();
        }
        this.correct = correct;
    }

    /**
     * getter-method for the attribute total
     * @return the value of the attribute total
     */
    public int getTotal() {
        return total;
    }

    /**
     * setter-method for the attribute total
     * @param total the new value for the attribute total
     * @throws IllegalArgumentException is thrown, if total is negative
     */
    public void setTotal(int total) throws IllegalArgumentException {
        if (total < 0) {
            throw new IllegalArgumentException();
        }
        this.total = total;
    }

    /**
     * method which stores the wordtrainer into a file
     */
    public void store() {
        this.storage.store(this);
    }

    /**
     * method which load the wordtrainer from a file
     */
    public void load() {
        this.storage.load(this);
        changeCurrentIndex();
    }

    /**
     * method which returns the currentWord
     * @return the value of this word
     */
    public Word getCurrentWord() {
        return words.get(currentIndex);
    }

    /**
     * method which compares a string to the current word
     * @param input the string which is compared
     * @return whether they are the same
     */
    public boolean check(String input) {
        return input.toLowerCase().equals(getCurrentWord().getWord().toLowerCase());
    }

    /**
     * method which changes the current index randomly
     */
    public void changeCurrentIndex() {
        int random;
        do {
            random = new Random().nextInt(words.size());
        } while (random == currentIndex);
        currentIndex = random;
    }
}
