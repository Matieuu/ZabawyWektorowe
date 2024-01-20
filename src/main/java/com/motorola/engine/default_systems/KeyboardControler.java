package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardControler extends GameSystem implements KeyListener {
    private String PresedKeys;
    private String RelasedKeys;
    public KeyboardControler(Game mygame){
        super(mygame);
    }

    /**
     *
     * @param gameObject
     */
    @Override
    public void addToGameObjectValues(GameObject gameObject) {
        gameObject.addValue("PressKeys","");
        gameObject.addValue("RelasedKeys","");
    }

    @Override
    public void update() {

    }

    @Override
    public void keyTyped(KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(KeyEvent keyEvent) {

    }

    @Override
    public void keyReleased(KeyEvent keyEvent) {

    }
}
