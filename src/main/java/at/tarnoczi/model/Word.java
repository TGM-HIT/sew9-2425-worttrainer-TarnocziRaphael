package at.tarnoczi.model;

import java.net.URL;

/**
 * class, which represents a word
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Word {
    private String word;
    private String url;

    /**
     * constructor
     * @param word the value for the attribute word
     * @param url the value for the attribute url
     */
    public Word(String word, String url) {
        this.setWord(word);
        this.setUrl(url);
    }

    /**
     * getter-method for the attribute word
     * @return the value of the attribute word
     */
    public String getWord() {
        return word;
    }

    /**
     * setter-method for the attribute word
     * @param word the new value for the attribute word
     * @throws IllegalArgumentException is thrown, if the parameter is empty or null
     */
    public void setWord(String word) throws IllegalArgumentException {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        this.word = word;
    }

    /**
     * getter-method for the attribute url
     * @return the value of the attribute url
     */
    public String getUrl() {
        return url;
    }

    /**
     * setter-method for the attribute url
     * @param url the new value for the attribute url
     * @throws IllegalArgumentException is thrown, if the parameter is empty, null or an invalid url
     */
    public void setUrl(String url) throws IllegalArgumentException {
        if (url == null ||url.isEmpty()|| !validateUrl(url)) {
            throw new IllegalArgumentException("Url cannot be null or is invalid");
        }
        this.url = url;
    }

    /**
     * method which checks, if an url is valid
     * @param url the url to be checked
     * @return whether the url is valid or not
     */
    public boolean validateUrl(String url) {
        try {
            URL temp = new URL(url);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
