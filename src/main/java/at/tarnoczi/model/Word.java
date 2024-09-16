package at.tarnoczi.model;

import java.net.URL;

/**
 * Klasse, die einen Wort-Eintrag darstellt
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Word {
    private String word;
    private String url;

    public Word(String word, String url) {
        this.setWord(word);
        this.setUrl(url);
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) throws IllegalArgumentException {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        if (url == null ||url.isEmpty()|| !validateUrl(url)) {
            throw new IllegalArgumentException("Url cannot be null or is invalid");
        }
        this.url = url;
    }

    public boolean validateUrl(String url) {
        try {
            URL temp = new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
