package com.motorola.engine;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

/**
 * Klasa okienka
 */
public class GameWindow extends JFrame {

    /**
     * Konstruktor Okna
     * @param gamePanel Instancja panelu gry
     */
    public GameWindow(GamePanel gamePanel) {
        this.add(gamePanel);
        this.pack();

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }
            @Override
            public void windowLostFocus(WindowEvent e) {
            }
        });
    }
}
