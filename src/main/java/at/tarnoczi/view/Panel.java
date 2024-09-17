package at.tarnoczi.view;

import at.tarnoczi.controller.Controller;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Panel extends JPanel {

    private Controller c;
    private JLabel correct, total;
    private JButton save, load;
    private JTextField input;
    private String inputString;
    public Panel(Controller c) throws IOException {
        this.setLayout(new BorderLayout());
        this.c = c;

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
        ImageIcon icon = new ImageIcon(new URL("https://i.pinimg.com/originals/8e/b7/f8/8eb7f846e94c68d25df1d127bfd945c4.png"));
        Image image = icon.getImage();
        image = image.getScaledInstance(250,250,Image.SCALE_SMOOTH);
        JLabel picture = new JLabel(new ImageIcon(image));
        center.add(picture);
        this.add(center, BorderLayout.CENTER);

        //Textinput & Buttons - BOTTOM

        JPanel bottom = new JPanel();
        bottom.setLayout(new GridLayout(2,1));
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

        this.add(bottom, BorderLayout.PAGE_END);





    }
}
