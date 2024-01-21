package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.states.State;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControler extends GameSystem implements KeyListener {

//    private String PresedKeys;
//    private String RelasedKeys;

    public KeyboardControler(Game mygame){
        super(mygame);
        mygame.getPanel().addKeyListener(this);
    }

    /**
     *
     * @param gameObject
     */
    @Override
    public void addToGameObjectValues(GameObject gameObject) {
//        gameObject.addValue("PressKeys","");
//        gameObject.addValue("RelasedKeys","");
    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).keyTyped(keyEvent);
    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).keyPressed(keyEvent);
    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).keyReleased(keyEvent);
    }
}
