package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;

import java.awt.*;

public class AsteroidsSystem extends GameSystem {

    public float asteroidDelay;
    public float currentAsteroidDelay;

    public AsteroidsSystem(Game mygame_){
        super(mygame_);
        this.addObjectsByName("*Asteroid");
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }

    @Override
    public void update(double delta) {
        if (asteroidDelay > currentAsteroidDelay){
            currentAsteroidDelay += delta;
        }
        else{
            new GameObject(game,"Asteroid");
        }
    }

    @Override
    public void render(Graphics g) {

    }

}
