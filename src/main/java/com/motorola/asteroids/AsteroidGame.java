package com.motorola.asteroids;
import com.motorola.engine.*;

import java.awt.*;

public class AsteroidGame extends GameSystem {
    public AsteroidGame(GameWindow myGamewindow){
        super(new Game("Asteroids",myGamewindow));

        new GameObject(this.mygame,"Player");
        this.addObjectByName("Player");
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {

    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics g) {

    }
}
