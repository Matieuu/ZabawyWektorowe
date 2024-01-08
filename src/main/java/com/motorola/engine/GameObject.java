package com.motorola.engine;

import java.util.HashMap;
import java.util.Map;

/*
    GameObject
 */
public class GameObject {
    protected Game mygame;
    protected String name;
    protected String keyname;
    protected Map<String, Object> dane;
    public GameObject(Game mygame,String name){
        this.dane = new HashMap<>();
        this.name = name;
        this.mygame = mygame;
        keyname = mygame.genKeyName(this.name);
        mygame.addGameObject(this);
    }

    public Object getValue(String valueName){
        try {
            if (dane.containsKey(valueName)) {
                return dane.get(valueName);
            } else {
                throw new IllegalArgumentException("KeyValue '" + valueName + "' does not exist in GameObect" + name + " With " + keyname);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Błąd: " + e.getMessage());
        }
        return null;
    }
    public void addValue(String valueName,Object ofValue){
        dane.put(valueName,ofValue);
    }
    public String getKeyName(){return keyname;}
    public String getName(){return name;}
}
