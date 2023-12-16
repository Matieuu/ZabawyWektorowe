package com.motorola.inputs;

import javax.swing.event.MouseInputListener;
import java.awt.event.*;

/**
 * Klasa obsługujące wejścia dla myszy
 */
public class MouseInputs implements MouseInputListener, MouseWheelListener {

    /**
     * Konstruktor
     */
    public MouseInputs() {}

    /**
     * Wywoływana w przypadku wciśnięcia przycisku
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(MouseEvent e) {
    }

    /**
     * Wywołuwana w przypadku puszczenia przycisku myszy
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(MouseEvent e) {
    }

    /**
     * Wywoływana w przypadku przytrzymania klawiszy myszy
     * I jednoczesnym przesunięciu myszy
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(MouseEvent e) {
    }

    /**
     * Wywoływana w przypadku poruszenia myszką
     * Nie wywołuje się w przypadku mouseDragged()
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(MouseEvent e) {
    }

    /**
     * Wywoływana w przypadku scrollowania
     * @param e the event to be processed
     */
    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
    }

    // Są lepsze sposoby, uwierz mi
    /**
     * Połączenie mousePressed i mouseReleased
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(MouseEvent e) {
    }
    /**
     * Sprawdza czy mysz weszła na obszar komponentu
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(MouseEvent e) {

    }
    /**
     * Sprawdza czy mysz opuściła obszar komponentu
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(MouseEvent e) {

    }
}
