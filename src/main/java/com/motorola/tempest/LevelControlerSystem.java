package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.graphics.Model;

import java.awt.*;
import java.util.logging.Level;

public class LevelControlerSystem extends GameSystem {

    private Model firstLevel;
    private Renderer3D render3d;

    LevelControlerSystem(Game game, Renderer3D render3d){
        super(game);
        this.render3d = render3d;
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
