package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.InputListener;

import java.awt.event.KeyEvent;

public class TempestInput implements InputListener {

    private Game game;

    public TempestInput(Game game) {
        this.game = game;
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                // TODO on right
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                // TODO on left
            }
            case KeyEvent.VK_ESCAPE -> game.getStateManager().pop();
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {

    }
}
