package com.motorola;

import com.motorola.engine.Game;
import com.motorola.engine.GameWindow;

/**
 * Klasa glowna
 */
public class MainClass {
    /**
     * Konstruktor
     */
    public MainClass() {}

    /**
     * Metoda glowna
     * @param args Argumety, wejsciowe
     */
    public static void main(String[] args) {
        Game game = new Game("Zabawy Wektorowe", "menu");
    }
}
