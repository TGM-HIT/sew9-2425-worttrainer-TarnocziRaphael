package at.tarnoczi.view;

import javax.swing.*;

/**
 * frame-class
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Frame extends JFrame {

    /**
     * constructor
     * @param p the panel which is displayed
     */
    public Frame(JPanel p) {
        super("WordTrainer Raphael Tarnoczi 5AHIT");
        this.add(p);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(500,500);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
