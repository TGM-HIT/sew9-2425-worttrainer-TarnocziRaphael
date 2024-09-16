package at.tarnoczi.controller;

import at.tarnoczi.view.Frame;
import at.tarnoczi.view.Panel;

import java.io.IOException;

/**
 * Beschreibung des Programms
 *
 * @author Raphael Tarnoczi
 * @version 2024-09-16
 */
public class Controller {
    private final Frame f;
    private Panel p;
    public Controller() throws IOException {
        this.p = new Panel(this);
        this.f = new Frame(this.p);
    }

    public static void main(String[] args) throws IOException {
        new Controller();
    }
}
