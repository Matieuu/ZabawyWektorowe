package com.motorola.engine;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *  GameSystem
*/
public abstract class GameSystem {
    protected Game mygame;
    protected ArrayList<GameObject> usedObjects;
    private ArrayList<String> activeAddObjects;

    /**
     * Konstructor for Gamesystem
     * @param mygame_
     */
    public GameSystem(Game mygame_){
        usedObjects = new ArrayList<GameObject>();
        activeAddObjects = new ArrayList<>();
        mygame = mygame_;
        mygame.addGameSystem(this);
    }
    /**
     * It add GameObjects with the same name to System
     * if you add a star before name it will before every iteration
     * find new GameObjects with that name
     * @param name
     */
    public void addObjectByName(String name){
        ArrayList<GameObject> objectsByName;
        if(name.charAt(0) == '*'){
            String justName = name.substring(1);
            activeAddObjects.add(justName);
            objectsByName = mygame.getObjectsByName(justName);
        }else {
            objectsByName = mygame.getObjectsByName(name);
        }
        usedObjects.addAll(objectsByName);
        for(GameObject gameObject : objectsByName){
            addToGameObjectValues(gameObject);
        }
    }
    /**
     * It add GameObjects with the same keyname to System
     * @param keyname
     */
    public void addObjectByKeyName(String keyname){
        GameObject objectByKey = mygame.getObjectByKey(keyname);
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
     * It will remove GameObjects with that keyname from System
     * @param keyname
     */
    public void removeObjectByKeyName(String keyname){
        Iterator<GameObject> iterator = usedObjects.iterator();
        while (iterator.hasNext()) {
            GameObject obj = iterator.next();
            if (obj.getKeyName().equals(keyname)) {
                iterator.remove();
            }
        }
    }
    /**
     * Function active search for GameObjects with active search name that can add to system
     */
    public void activeSearchForGameObjects(){
        for(String name :activeAddObjects){
            addObjectByName(name);
        }
    }
    /**
     * You have to defie what values object need for working with system
     */
    public abstract void addToGameObjectValues(GameObject gameObject);
    /**
     * Updating Funciton form Game
     */
    public abstract void update();
}