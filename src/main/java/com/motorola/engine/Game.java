package com.motorola.engine;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa gry
 */
public class Game extends JFrame implements Runnable {

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
    private Thread gameThread;
    private HashMap<String,GameObject> gameObjects;
    private ArrayList<GameSystem> gameSystems;

    /**
     * Konstruktor
     */
    public Game() {
        //Inicialization Arrays
        gameSystems = new ArrayList<GameSystem>();
        gameObjects = new HashMap<String,GameObject>();

        // Start game loop
        gameThread = new Thread(this);
        gameThread.start();

        //Inicialization Window
        this.pack();
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        this.setSize(this.windowWidth,this.windowHeight);
        this.setPreferredSize(new Dimension(this.windowWidth, this.windowHeight));

        this.setVisible(true);
        this.setFocusable(true);
        this.requestFocus();
    }

    /**
     * Adds GameSystem to arraylist
     */
    public void addGameSystem(GameSystem gameSystem){
        gameSystems.add(gameSystem);
    }

    /**
     * Adds GameObject to hashmap
     */
    public void addGameObject(GameObject gameObject){
        if(gameObjects.containsKey(gameObject.getKeyName())){
            //error? //or add clone
        }
        else {
            gameObjects.put(gameObject.getKeyName(),gameObject);
        }
    }

    /**
     * Function generates a key for GameObject to use hashmap
     * @param name
     * @return keyName
     */
    public String genKeyName(String name){
        return gameObjects.size()+name;
    }

    /**
     * Function return GameObject with field keyName
     */
    public GameObject getObjectByKey(String keyName){
        try {
            if (gameObjects.containsKey(keyName)) {
                return gameObjects.get(keyName);
            } else {
                throw new IllegalArgumentException("Does not exist a GameObect with that keyname" + keyName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return null;
    }
    /**
     * Function remove a game object from gameObject array and sub arrays in gameSystem by keyname
     * @param keyName
     */
    public void removeGameObject(String keyName) {
        try {
            if (gameObjects.containsKey(keyName)) {
                for(GameSystem gameSystem: gameSystems){
                    gameSystem.removeObjectByKeyName(keyName);
                }
                gameObjects.remove(keyName);
            } else {
                throw new IllegalArgumentException("Does not exist a GameObect with that keyname" + keyName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
    }

    /**
     * Function fings GameObjects with name and return a arraylist of its;
     * @param name
     * @return
     */
    public ArrayList<GameObject> getObjectsByName(String name){
        ArrayList<GameObject> subGameObjects = new ArrayList<>();
        for(GameObject gameObject : gameObjects.values()){
            if(gameObject.getName() == name){
                subGameObjects.add(gameObject);
            }
        }
        return subGameObjects;
    };

    /**
     * Wywoływana Const.UPS_SET razy na sekundę
     * Jej cel to aktualizowanie logiki gry
     */
    private void update() {
        for (GameSystem system : gameSystems) {
            system.activeSearchForGameObjects();
            system.update();
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);

        //brak implementacjie funkcji rysującej linie które
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
                this.update();
                updates++;
                deltaU--;
            }

            if (deltaF >= 1) {
                this.repaint();
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
}
