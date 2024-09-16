package at.tarnoczi.model;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 * Klasse, die es ermöglicht, den WortTrainer aus JSON zu laden und zu speichern
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class JSONStorage implements StrategyStorage{
    /**
     *
     */
    public JSONStorage() {}

    @Override
    public void load(WordTrainer wordTrainer) {
        try {
            String content = new String(Files.readAllBytes(Paths.get("wordTrainer.json")));
            JSONObject jsonObject = new JSONObject(content);

            //put total into wordtrainer
            int total;
            try {
                total = jsonObject.getInt("total");
            } catch (JSONException e) {
                total = 0;
            }
            wordTrainer.setTotal(total);

            //put correct into wordtrainer
            int correct;
            try {
                correct = jsonObject.getInt("correct");
            } catch (JSONException e) {
                correct = 0;
            }
            wordTrainer.setCorrect(correct);

            //put words into wordtrainer
            JSONArray words = jsonObject.getJSONArray("words");
            ArrayList<Word> wordList = new ArrayList<>();
            for(Object o : words) {
                JSONObject wordObject = (JSONObject) o;
                String word = wordObject.getString("word");
                String url = wordObject.getString("url");
                wordList.add(new Word(word, url));
            }

            wordTrainer.setWords(wordList);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void store(WordTrainer wordTrainer) {
        try {
            JSONObject jsonObject = new JSONObject();

            //add total
            jsonObject.put("total", wordTrainer.getTotal());

            //add correct
            jsonObject.put("correct", wordTrainer.getCorrect());

            //add words
            JSONArray words = new JSONArray();
            for (Word word : wordTrainer.getWords()) {
                JSONObject wordObject = new JSONObject();
                wordObject.put("word", word.getWord());
                wordObject.put("url", word.getUrl());
                words.put(wordObject);
            }

            jsonObject.put("words", words);

            //save file
            Files.write(Paths.get("wordTrainer.json"), jsonObject.toString(4).getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new WordTrainer();
    }
}
