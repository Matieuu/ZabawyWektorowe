package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.InputListener;
import com.motorola.engine.states.State;

import java.awt.event.KeyEvent;

public class MenuInputListener implements InputListener {

    private Game game;
    private State state;

    public MenuInputListener(Game game, State state) {
        this.game = game;
        this.state = state;
    }

    @Override
    public void onKeyPress(KeyEvent e) { }

    @Override
    public void onKeyRelease(KeyEvent e) { }
}
