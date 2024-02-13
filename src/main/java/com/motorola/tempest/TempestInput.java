package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.InputListener;

import java.awt.*;
import java.awt.event.KeyEvent;

public class TempestInput implements InputListener {

    private boolean pressedLeft;
    private boolean pressedRight;
    private boolean relasedShoot;

    private Game game;
    private GameObject player;

    public TempestInput(Game game,GameObject player) {
        this.game = game;
        this.player = player;
        player.setValue("moveLeft",pressedLeft);
        player.setValue("moveRight",pressedRight);
        player.setValue("shoot",relasedShoot);
    }

    public void update(double delta) {

        player.setValue("moveLeft",pressedLeft);
        player.setValue("moveRight",pressedRight);
        player.setValue("shoot", relasedShoot);

        relasedShoot = false;
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                pressedRight = true;
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                pressedRight = false;
            }
            case KeyEvent.VK_ESCAPE -> game.getStateManager().pop();
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> {
                pressedRight = false;
            }
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> {
                pressedLeft = false;
            }
            case KeyEvent.VK_X -> {
                relasedShoot = true;
            }
        }
    }
}
