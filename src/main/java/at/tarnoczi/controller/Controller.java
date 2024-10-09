package at.tarnoczi.controller;

import at.tarnoczi.model.WordTrainer;
import at.tarnoczi.view.Frame;
import at.tarnoczi.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Controller-Class, that represents the connection between view and model
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Controller implements ActionListener {
    private final Frame f;
    private Panel p;
    private WordTrainer trainer;

    /**
     * Constructor
     */
    public Controller(){
        this.trainer = new WordTrainer();
        try {
            this.p = new Panel(this);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.f = new Frame(this.p);
    }

    /**
     * main-method, which is executed when running the program
     * @param args possible parameters
     */
    public static void main(String[] args) {
        new Controller();
    }

    /**
     * method, which is called when an event in the view is triggered (for example save or load)
     * @param e the event to be processed
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "input":
                if (this.trainer.check(this.p.getInput())) {
                    trainer.setCorrect(getCorrect()+1);
                    this.trainer.changeCurrentIndex();
                    this.p.nextWord(this.trainer.getCurrentWord().getUrl());
                }
                trainer.setTotal(getTotal()+1);
                break;
            case "save":
                this.trainer.store();
                break;
            case "load":
                this.trainer.load();
                this.p.nextWord(this.trainer.getCurrentWord().getUrl());
                break;
            default:
                System.out.printf("idk what happened");
        }
    }

    /**
     * method returns the url of the current word
     * @return the url of the current wordf
     */
    public String getUrl() {
        return trainer.getCurrentWord().getUrl();
    }

    /**
     * method returns the number of correct guessed words
     * @return the number
     */
    public int getCorrect() {
        return this.trainer.getCorrect();
    }

    /**
     * method returns the number the total guessed words
     * @return the number
     */
    public int getTotal() {
        return this.trainer.getTotal();
    }

}
