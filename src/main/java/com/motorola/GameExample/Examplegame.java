package com.motorola.GameExample;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;

public class Examplegame {
    public void MakeExampleGame(){
        Game Examplegame = new Game();
        ExampleSystem Examplesys = new ExampleSystem(Examplegame);

        GameObject player = new GameObject(Examplegame,"Player");

        Examplesys.addObjectByName("Player");

    }
}
