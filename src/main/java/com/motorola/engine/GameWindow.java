package com.motorola.engine;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {

    // Konstruktor
    public GameWindow() {
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

    public void addPanel(GamePanel gamePanel){
        this.add(gamePanel);
    }
}