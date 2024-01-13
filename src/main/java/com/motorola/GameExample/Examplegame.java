package com.motorola.GameExample;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;

public class Examplegame {
    public void MakeExampleGame(){
        Game Examplegame = new Game();
        ExampleSystem Examplesys = new ExampleSystem(Examplegame);

        new GameObject(Examplegame,"Player");
        new GameObject(Examplegame,"Object");

        //Examplegame.removeGameObject();

        Examplesys.addObjectByName("Player");

    }
}
