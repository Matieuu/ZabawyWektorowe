package com.motorola.engine;


/*
    GameObject
 */
public class GameObject {
    private int id;
    private String name;
    public GameObject(int id,String name){
        this.name = name;
        this.id = id;
    }
    public String getName(){return name;}
    public int getId(){return id;}
}
