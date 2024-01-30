package com.motorola.engine.default_systems;

import com.motorola.engine.Game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.HashMap;

public class KeyboardEventListener implements KeyListener {

    private Game game;
    public HashMap<Integer, KeyEvent> keysPressed;

    public KeyboardEventListener(Game game) {
        this.game = game;
        keysPressed = new HashMap<>();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (!keysPressed.containsKey(e.getKeyCode()))
            keysPressed.put(e.getKeyCode(), e);
        if (game.getStateManager().peek().getInputListener() != null)
            game.getStateManager().peek().getInputListener().onKeyPress(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (keysPressed.containsKey(e.getKeyCode())) {
            keysPressed.remove(e.getKeyCode());
            if (game.getStateManager().peek().getInputListener() != null)
                game.getStateManager().peek().getInputListener().onKeyRelease(e);
        }
    }

    public boolean isKeyPressed(int keyCode) {
        return keysPressed.containsKey(keyCode);
    }

    @Override
    public void keyTyped(KeyEvent e) { }
}