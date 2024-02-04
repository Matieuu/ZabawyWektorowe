package com.motorola.engine;

import com.motorola.engine.default_systems.KeyboardEventListener;

import javax.swing.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class GameWindow extends JFrame {

    private GamePanel statePanel;

    private KeyboardEventListener kbListener;

    // Konstruktor
    public GameWindow(String title, GamePanel panel) {
        super(title);
        add(panel);
        pack();

        kbListener = new KeyboardEventListener(panel.getGame());
        addKeyListener(kbListener);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        addWindowFocusListener(new WindowFocusListener() {
            @Override
            public void windowGainedFocus(WindowEvent e) {
            }
            @Override
            public void windowLostFocus(WindowEvent e) {
            }
        });

        setVisible(true);
    }
    public void getGamePanel(GamePanel panel){
        this.statePanel = panel;
    }
    public void addPanel(GamePanel gamePanel){
        add(gamePanel);
        pack();
    }
    public void rmPanel(GamePanel gamePanel) {
        statePanel = gamePanel;
        remove(gamePanel);
        pack();
    }
    public void setPanel(GamePanel gamePanel) {
        if (statePanel != null)
            remove(statePanel);
        add(gamePanel);
        pack();
    }

    public KeyboardEventListener getKbListener() {
        return kbListener;
    }
}