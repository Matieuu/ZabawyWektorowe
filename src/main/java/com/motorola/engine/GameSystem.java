package com.motorola.engine;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *  GameSystem
*/
public abstract class GameSystem {
    protected Game game;
protected List<GameObject> usedObjects;
    private List<String> activeAddObjects;

    /**
     * Konstructor for Gamesystem
     * @param game
     */
    public GameSystem(Game game){
        usedObjects = new ArrayList<GameObject>();
        activeAddObjects = new ArrayList<String>();
        this.game = game;
        game.addGameSystem(this);
    }
    /**
     * It add GameObjects with the same name to System
     * if you add a star before name it will before every iteration
     * find new GameObjects with that name
     * @param name
     */
    public void addObjectsByName(String name) {
        ArrayList<GameObject> objectsByName;
        if (name.charAt(0) == '*') {
            String justName = name.substring(1);
            activeAddObjects.add(justName);
            objectsByName = game.getObjectsByName(justName);
        } else {
            objectsByName = game.getObjectsByName(name);
        }
        usedObjects.addAll(objectsByName);
        for (GameObject gameObject : objectsByName) {
            addToGameObjectValues(gameObject);
        }
    }
    /**
     * It add GameObjects with the same keyName to System
     * @param keyName
     */
    public void addObjectByKeyName(String keyName){
        GameObject objectByKey = game.getObjectByKey(keyName);
        if (objectByKey == null) return;
        addToGameObjectValues(objectByKey);
        usedObjects.add(objectByKey);
    }
    /**
     * It will remove GameObjects with that name from System and activeSearch
     * @param name
     */
    public void removeObjectByName(String name){
        Iterator<String> iteratorA = activeAddObjects.iterator();
        while (iteratorA.hasNext()) {
            String iterName = iteratorA.next();
            if (iterName.equals(name)) {
                iteratorA.remove();
            }
        }
        Iterator<GameObject> iteratorG = usedObjects.iterator();
        while (iteratorG.hasNext()) {
            GameObject gameObject = iteratorG.next();
            if (gameObject.getName().equals(name)) {
                iteratorG.remove();
            }
        }
    }
    /**
     * It will remove GameObjects with that keyName from System
     * @param keyName
     * //przekomplikowana
     */
    public void removeObjectByKeyName(String keyName){
        Iterator<GameObject> iterator = usedObjects.iterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.next();
            if (obj.getKeyName().equals(keyName)) {
                iterator.remove();
            }
        }
    }

    /**
     * Direcly add GameObject to Array
     * @param object
     */
    public void addObject(GameObject object) {
        addToGameObjectValues(object);
        usedObjects.add(object);
    }

    /**
     * Direcly remove GameObject from Array
     * @param object
     */
    public void deleteObject(GameObject object) {
        usedObjects.remove(object);
    }


    /**
     * Function active search for GameObjects with active search name that can add to system
     * //upewnic czy nie ma bledow
     */
    public void activeSearchForGameObjects(){
        for(String name :activeAddObjects){
            addObjectsByName(name);
        }
    }
    /**
     * You have to define what values object need for working with system
     */
    public abstract void addToGameObjectValues(GameObject gameObject);
    /**
     * Updating Function form Game
     */
    public abstract void update(double delta);
    public abstract void render(Graphics g);
}