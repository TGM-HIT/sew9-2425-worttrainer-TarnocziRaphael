package at.tarnoczi.view;

import at.tarnoczi.controller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Panel-Klasse, in der alles grafische deklariert wird.
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Panel extends JPanel {

    private Controller c;
    private JLabel correct, total, picture;
    private JButton save, load;
    private JTextField input;
    private String url;

    /**
     * constructor
     * @param c the controller for events
     * @throws MalformedURLException is thrown if the url is invalid
     */
    public Panel(Controller c) throws MalformedURLException {
        this.setLayout(new BorderLayout()); //setting general layout
        this.c = c;
        this.url = c.getUrl();

        //TOP
        JPanel top = new JPanel();
        top.setLayout(new GridLayout(1,1));
        JLabel question = new JLabel("Welches Wort wird unten dargestellt (Eingabe zum Überprüfen)?");
        question.setHorizontalAlignment(JLabel.CENTER);
        top.add(question);
        this.add(top, BorderLayout.PAGE_START);

        //Image - CENTER
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(1,1));
        ImageIcon icon = new ImageIcon(new URL(this.url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);

        //Textinput,Buttons & Stats - BOTTOM
        //General
        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3,1));
        bottom.setBorder(new EmptyBorder(0,20,20,20));

        //Textinput
        this.input = new JTextField();
        bottom.add(input);

        //Buttons
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1,2));
        this.save = new JButton("Save");
        this.load = new JButton("Load");
        buttons.add(save);
        buttons.add(load);
        bottom.add(buttons);

        //Stats, wo angezeigt wird, wie viele Antworten richtig und falsch sind
        JPanel stats = new JPanel();
        stats.setLayout(new GridLayout(2,2));
        JLabel textC = new JLabel("Richtige Wörter:");
        JLabel textT = new JLabel("Gesamtanzahl:");
        this.correct = new JLabel(String.valueOf(this.c.getCorrect()));
        this.total = new JLabel(String.valueOf(this.c.getTotal()));
        stats.add(textC);
        stats.add(textT);
        stats.add(correct);
        stats.add(total);
        bottom.add(stats);

        this.add(bottom, BorderLayout.PAGE_END);

        //ActionListener
        this.input.addActionListener(this.c);
        this.input.setActionCommand("input");

        this.save.addActionListener(this.c);
        this.save.setActionCommand("save");

        this.load.addActionListener(this.c);
        this.load.setActionCommand("load");
    }

    /**
     * method which returns the value of the textinput
     * @return the string value of the input
     */
    public String getInput() {
        return this.input.getText();
    }

    /**
     * method which makes sure the next word is displayed correctly and all the other stats are changed as well
     * @param url the url of the image of the next word
     */
    public void nextWord(String url) {
        this.input.setText(""); //Textfeld leeren
        reloadStats();
        this.url = url;
        try {
            reloadImage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void reloadStats() {
        this.correct.setText(String.valueOf(this.c.getCorrect()));
        this.total.setText(String.valueOf(this.c.getTotal()));
    }

    /**
     * methods which reloads the picture of the next word
     * @throws MalformedURLException is thrown if the url is invalid
     */
    private void reloadImage() throws MalformedURLException {
        JPanel center = new JPanel();
        ImageIcon icon = new ImageIcon(new URL(this.url));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        this.picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);
    }
}
