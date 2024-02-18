package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.default_systems.InputListener;

import java.awt.event.KeyEvent;

public class AsteroidsInput implements InputListener {

    private boolean pressedForward;
    private boolean pressedBackward;
    private boolean pressedLeft;
    private boolean pressedRight;
    private boolean pressedShoot;

    private Game game;
    private GameObject player;

    public AsteroidsInput(Game game, GameObject player) {
        this.game = game;
        this.player = player;

        pressedForward = false;
        pressedBackward = false;
        pressedLeft = false;
        pressedRight = false;
        pressedShoot = false;

        player.setValue("moveForward", pressedForward);
        player.setValue("moveBackward", pressedBackward);
        player.setValue("moveLeft", pressedLeft);
        player.setValue("moveRight", pressedRight);
        player.setValue("shoot", pressedShoot);
    }

    public void update(double delta) {
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> pressedRight = true;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> pressedLeft = true;
            case KeyEvent.VK_UP, KeyEvent.VK_W -> pressedForward = true;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> pressedBackward = true;
            case KeyEvent.VK_X -> pressedShoot = true;
            case KeyEvent.VK_ESCAPE -> game.getStateManager().pop();
        }

        player.setValue("moveForward", pressedForward);
        player.setValue("moveBackward", pressedBackward);
        player.setValue("moveLeft", pressedLeft);
        player.setValue("moveRight", pressedRight);
        player.setValue("shoot", pressedShoot);
    }

    @Override
    public void onKeyRelease(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> pressedRight = true;
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> pressedLeft = true;
            case KeyEvent.VK_UP, KeyEvent.VK_W -> pressedForward = true;
            case KeyEvent.VK_DOWN, KeyEvent.VK_S -> pressedBackward = true;
            case KeyEvent.VK_X -> pressedShoot = false;
        }

        player.setValue("moveForward", pressedForward);
        player.setValue("moveBackward", pressedBackward);
        player.setValue("moveLeft", pressedLeft);
        player.setValue("moveRight", pressedRight);
        player.setValue("shoot", pressedShoot);
    }
}
