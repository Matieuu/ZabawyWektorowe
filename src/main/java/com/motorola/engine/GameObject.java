package com.motorola.engine;

import java.util.HashMap;
import java.util.Map;

/**
 *  GameObject
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
    private Map<String, Object> dane;
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
    public void addValue(String valueName, Object ofValue){
        dane.put(valueName,ofValue);
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
