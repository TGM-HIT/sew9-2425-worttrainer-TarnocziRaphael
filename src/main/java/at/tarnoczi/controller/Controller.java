package at.tarnoczi.controller;

import at.tarnoczi.model.WordTrainer;
import at.tarnoczi.view.Frame;
import at.tarnoczi.view.Panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Controller implements ActionListener {
    private final Frame f;
    private Panel p;
    private WordTrainer trainer;
    public Controller() throws IOException {
        this.trainer = new WordTrainer();
        this.p = new Panel(this);
        this.f = new Frame(this.p);
    }

    public static void main(String[] args) throws IOException {
        new Controller();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        switch (actionCommand) {
            case "input":
                if (this.trainer.check(this.p.getInput())) {
                    trainer.setCorrect(getCorrect()+1);
                }
                trainer.setTotal(getTotal()+1);
                this.trainer.changeCurrentIndex();
                this.p.nextWord(this.trainer.getCurrentWord().getUrl());
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

    public String getUrl() {
        return trainer.getCurrentWord().getUrl();
    }

    public int getCorrect() {
        return this.trainer.getCorrect();
    }
    public int getTotal() {
        return this.trainer.getTotal();
    }

}
