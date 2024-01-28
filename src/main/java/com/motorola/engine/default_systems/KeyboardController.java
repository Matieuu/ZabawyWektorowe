package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class KeyboardController extends GameSystem implements KeyListener {

    private ArrayList<Integer> checkForKeys;
    private ArrayList<Character> pressedKeys;
    private ArrayList<Character> releasedKeys;

    public KeyboardController(Game mygame){
        super(mygame);

        /*checkForKeys = (ArrayList<Integer>) List.of(
                KeyEvent.VK_LEFT, KeyEvent.VK_RIGHT, KeyEvent.VK_UP, KeyEvent.VK_DOWN,
                KeyEvent.VK_ENTER, KeyEvent.VK_SHIFT, KeyEvent.VK_ESCAPE,
                KeyEvent.VK_Z, KeyEvent.VK_X, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_Q, KeyEvent.VK_E
        );*/ //zategowalem to bo wywalalo blad /sg

        mygame.getPanel().addKeyListener(this);
    }

    /**
     *
     * @param gameObject
     */
    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }

    @Override
    public void update(double delta) {
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        if (checkForKeys.contains(keyEvent.getKeyCode()))
            pressedKeys.add(keyEvent.getKeyChar());
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        if (pressedKeys.contains(keyEvent.getKeyChar()))
            pressedKeys.add(keyEvent.getKeyChar());
    }
}
