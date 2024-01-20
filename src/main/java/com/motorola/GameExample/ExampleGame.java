package com.motorola.GameExample;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;

public class ExampleGame {
    public void MakeExampleGame(){
        Game Examplegame = new Game("ExampleTitle");
        ExampleSystem Examplesys = new ExampleSystem(Examplegame);

        new GameObject(Examplegame,"Player");
        new GameObject(Examplegame,"Object");

        //Examplegame.removeGameObject();

        Examplesys.addObjectByName("Player");

    }
}
