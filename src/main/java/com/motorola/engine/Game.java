package com.motorola.engine;

import com.motorola.Line2D;
import com.motorola.Vector2;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Klasa gry
 */
public class Game implements Runnable {
    public static final int FPS_SET = 60;
    private GamePanel mypanel;
    private Thread gameThread;
    private HashMap<String,GameObject> gameObjects;
    private ArrayList<GameSystem> gameSystems;
    private ArrayList<Line2D> gameRender;

    /**
     * Konstruktor
     */
    public Game(String title) {
        mypanel = new GamePanel(this);

        //Inicialization Arrays
        gameSystems = new ArrayList<GameSystem>();
        gameObjects = new HashMap<String,GameObject>();
        gameRender = new ArrayList<Line2D>();

        // Start game loop
        gameThread = new Thread(this);
        gameThread.start();

        //Inicialization Window

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
            //add clone
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
     * //nie potrzebne?
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
            System.out.println("Critical Error: " + e.getMessage());
            System.exit(1);
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
     * Function adds to quente line to draw
     */
    public void drawLine2D(Vector2 start,Vector2 end,Color color){
        gameRender.add(new Line2D(start,end,color));
    }
    /**
     * Function adds to quente line to draw
     */
    public void drawLine2D(Line2D line){
        gameRender.add(line);
    }
    /**
     * Wywoływana Const.UPS_SET razy na sekundę
     * Jej cel to aktualizowanie gry
     */
    private void update() {
        for (GameSystem system : gameSystems) {
            system.activeSearchForGameObjects();
            system.update();
        }
    }

    /**
     * Function return a Dimension of window
     * @return Dimension
     */
    public Dimension getWindowDimension(){
        return mypanel.getSize();
    }

    public void paint(Graphics g){
        for(Line2D line: gameRender) {
            g.setColor(line.color);
            g.drawLine((int) line.start.getX(), (int) line.start.getY(), (int) line.end.getX(), (int) line.end.getY());
        }
        gameRender.clear();
    }

    @Override
    public void run() {
        double timePerFrame = 1000000000.0 / FPS_SET;

        long previousTime = System.nanoTime();
        long lastCheck = System.currentTimeMillis();

        int frames = 0;
        double deltaF = 0;

        while (true) {
            long currentTime = System.nanoTime();

            deltaF += (currentTime - previousTime) / timePerFrame;
            previousTime = currentTime;

            if (deltaF >= 1) {
                update();
                mypanel.repaint();
                frames++;
                deltaF--;
            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
    }
}
