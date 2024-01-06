package com.motorola.engine;

import java.awt.*;
import java.util.ArrayList;

/**
 * Klasa gry
 */
public class Game implements Runnable {

    /**
     * Szerokość okna
     */
    public int windowWidth = 1600;
    /**
     * Wysokość okna
     */
    public int windowHeight = 900;

    /**
     * Limit FPS
     */
    public static final int FPS_SET = 120;
    /**
     * Limit UPS
     */
    public static final int UPS_SET = 240;

    private GameWindow gameWindow;
    private GamePanel gamePanel;
    private Thread gameThread;

    private ArrayList<GameObject> objects;
    private ArrayList<GameSystem> gameSystems;

    /**
     * Konstruktor
     */
    public Game() {
        // Inicjalizacja okna aplikacji
        gamePanel = new GamePanel(this);
        gameWindow = new GameWindow(gamePanel);

        gameWindow.setVisible(true);
        gamePanel.setFocusable(true);
        gamePanel.requestFocus();

        // Start game loop
        gameThread = new Thread(this);
        gameThread.start();
    }

    /**
     * Wywoływana Const.UPS_SET razy na sekundę
     * Jej cel to aktualizowanie logiki gry
     */
    public void update() {

    }

    /**
     * Wywoływana Const.FPS_SET razy na sekundę
     * Jej cel to renderowanie gry w GamePanel
     * @param g Obiekt umożliwiający rysowanie na ekranie (domyślnie: Graphics)
     */
    public void render(Graphics g) {
    }

    @Override
    public void run() {
        double timePerFrame = Math.pow(10, 9) / FPS_SET;
        double timePerUpdate = Math.pow(10, 9) / UPS_SET;

        long previousTime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        int frames = 0;
        int updates = 0;

        double deltaU = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaU += (currentTime - previousTime) / timePerUpdate;
            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaU >= 1) {
                update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                gamePanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames + " | UPS: " + updates);
                frames = 0;
                updates = 0;
            }
        }
    }

    public static class Component {
        public String id;

        public Component(String id) {
            this.id = id;
        }
    }
}