package com.motorola.asteroids;
import com.motorola.engine.*;

import java.awt.*;
import java.util.List;

public class AsteroidGame extends GameSystem {
    public AsteroidGame() {
        super(new Game("Asteroids"));

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
