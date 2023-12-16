package com.motorola.inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Klasa obsługująca wejścia dla klawiatury
 */
public class KeyboardInputs implements KeyListener {

    /**
     * Konstruktor
     */
    public KeyboardInputs() {}

    /**
     * Wywoływana w przypadku wciśnięcia klawisza na klawiaturze
     * @param e the event to be processed
     */
    @Override
    public void keyPressed(KeyEvent e) {
    }

    /**
     * Wywoływana w przypadku puszczenia klawisza na klawiaturze
     * @param e the event to be processed
     */
    @Override
    public void keyReleased(KeyEvent e) {
    }

    /**
     * Połączenie dwóch poprzednich metod w jedność
     * @param e the event to be processed
     */
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
