package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;

import java.awt.*;

public class ColisionsSystem extends GameSystem {

    /**
     * Konstructor for Gamesystem
     *
     * @param game
     */
    public ColisionsSystem(Game game) {
        super(game);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) { }

    @Override
    public void update(double delta) { }

    @Override
    public void render(Graphics g) { }
}
