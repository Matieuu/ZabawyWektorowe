package com.motorola.engine;

import com.motorola.engine.states.StateManager;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Klasa gry
 */
public class Game implements Runnable {

    public static final int FPS_SET = 60;

    private GameWindow myWindow;
    private GamePanel myPanel;
    private StateManager stateManager;
    private Thread gameThread;

    private Map<String,GameObject> gameObjects;
    private List<GameSystem> gameSystems;
    /**
     * Konstruktor
     */
    public Game(String title) {
        myPanel = new GamePanel(this);
        myWindow = new GameWindow(myPanel);

        //Inicialization Arrays
        gameSystems = new ArrayList<GameSystem>();
        gameObjects = new HashMap<String,GameObject>();
        stateManager = new StateManager(this);

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
        } else {
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
                throw new IllegalArgumentException("Does not exist a GameObject with that keyname " + keyName);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Critical Error: " + e.getMessage());
            System.exit(1);
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
                throw new IllegalArgumentException("Does not exist a GameObject with that keyname " + keyName);
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
    }

    /**
     * Wywolywana FPS_SET razy na sekunde
     * Jej cel to rysowanie gry
     */
    private void update(double delta) {
        stateManager.update(delta);
    }

    /** Jej cel to aktualizowanie gry */
    public void render(Graphics g){
        stateManager.render(g);
    }

    /**
     * Function return a Dimension of window
     * @return Dimension
     */
    public Dimension getWindowDimension(){
        return myPanel.getSize();
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
                update(deltaF);
                myPanel.repaint();
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

    public GamePanel getPanel() {
        return myPanel;
    }

    public StateManager getStateManager() {
        return stateManager;
    }

    public List<GameSystem> getGameSystems() {
        return gameSystems;
    }

    public void clearGameECS(){
        gameObjects.clear();
        gameSystems.clear();
    }
}
