package com.motorola.engine.states;

import com.motorola.engine.Game;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.KeyboardControler;
import com.motorola.engine.default_systems.MouseControler;

import java.awt.*;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
        game.addGameSystem(new KeyboardControler(game));
        game.addGameSystem(new MouseControler(game));
    }

    public void stateUpdate(double delta) {
        for (GameSystem system : game.getGameSystems()) {
            system.activeSearchForGameObjects();
            system.update(delta);
        }

        update(delta);
    }

    public void render(Graphics g) {
        for (GameSystem system : game.getGameSystems()) {
            system.activeSearchForGameObjects();
            system.render(g);
        }
    }

    public abstract void update(double delta);
}
