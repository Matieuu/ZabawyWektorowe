package com.motorola.engine.states;

import com.motorola.engine.Game;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.KeyboardController;
import com.motorola.engine.default_systems.MouseController;

import java.awt.*;

public abstract class State {

    protected Game game;

    public State(Game game) {
        this.game = game;
        game.clearGameECS();
        game.addGameSystem(new KeyboardController(game));
        game.addGameSystem(new MouseController(game));
    }

    public void stateUpdate(double delta) {
        update(delta);
        for (GameSystem system : game.getGameSystems()) {
            system.activeSearchForGameObjects();
            system.update(delta);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, game.getWindowDimension().width, game.getWindowDimension().height);
        for (GameSystem system : game.getGameSystems()) {
            system.activeSearchForGameObjects();
            system.render(g);
        }
    }

    public abstract void update(double delta);
}
