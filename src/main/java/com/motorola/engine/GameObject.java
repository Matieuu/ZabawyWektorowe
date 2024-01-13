package com.motorola.engine;

import java.util.HashMap;
import java.util.Map;

/**
 *  GameObject
 *  //void update
 *  //abstract class
 */
public class GameObject {
    protected Game mygame;
    /**
     * Nazwa obiektu ma przectawiać jego typ w grze
     */
    private String name;
    /**
     * Nazwa klucz do tablicy obiektów
     */
    private String keyname;
    /**
     * Hash mapa pozwala na dodanie klucza(Srring) i Wartości(Jaki kolniek Obiekt który castujemy do naszego w przypadku nieprawidłowego castowania powinien! wyrzucić błąd)
     */
    private Map<String, Object> components;
    public GameObject(Game mygame,String name){
        this.components = new HashMap<>();
        this.name = name;
        this.mygame = mygame;
        keyname = mygame.genKeyName(this.name);
        mygame.addGameObject(this);
    }

    /**
     * Functiom will return true if valuename is in hashmap components
     * @param valueName
     * @return
     */
    public boolean isHaveValue(String valueName){
        return components.containsKey(valueName);
    }
    /**
     * Function returns value of information with valueName
     * @param valueName
     * @return Objecct
     */
    public Object getValue(String valueName){
        try {
            if (components.containsKey(valueName)) {
                return components.get(valueName);
            } else {
                throw new IllegalArgumentException("KeyValue '" + valueName + "' does not exist in GameObect" + name + " With " + keyname);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Critical Error: " + e.getMessage());
            System.exit(1);
        }
        return null;
    }
    public void addValue(String valueName, Object ofValue){
        components.put(valueName,ofValue);
    }
    public String getKeyName(){return keyname;}
    public String getName(){return name;}
    public Game getGame(){return mygame;}
    /**
     * Function deletes object from all arrays
     */
    public void destroy(){
        mygame.removeGameObject(keyname);
    }
}
