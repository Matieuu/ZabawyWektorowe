package com.motorola.engine.states;

import com.motorola.engine.Game;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.InputListener;

import java.awt.*;

public abstract class State {

    protected Game game;

    protected InputListener inputListener;

    public State(Game game) {
        game.clearGameECS();
        this.game = game;
        inputListener = null;
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

    public void setInputListener(InputListener inputListener) {
        this.inputListener = inputListener;
    }
    public InputListener getInputListener() {
        return inputListener;
    }
}
