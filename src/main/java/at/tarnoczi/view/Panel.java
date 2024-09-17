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
    public Panel(Controller c) throws IOException {
        this.setLayout(new BorderLayout());
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

        //Textinput & Buttons - BOTTOM

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(3,1));
        bottom.setBorder(new EmptyBorder(0,20,20,20));
        this.input = new JTextField();
        bottom.add(input);

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

    public String getInput() {
        return this.input.getText();
    }

    public void nextWord(String url) {
        this.input.setText(""); //Textfeld leeren
        this.correct.setText(String.valueOf(this.c.getCorrect())); //stats anpassen
        this.total.setText(String.valueOf(this.c.getTotal()));
        this.url = url;
        try {
            reloadImage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

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
