package com.motorola.Asteroids;
import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GamePanel;
import com.motorola.engine.GameSystem;

public class AsteroidGame extends GameSystem {
    public AsteroidGame(){
        super(new Game("Asteroids"));

        new GameObject(this.mygame,"Player");
        this.addObjectByName("Player");

    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {

    }

    @Override
    public void update() {

    }
}
