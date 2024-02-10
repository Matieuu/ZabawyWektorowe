package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.InputListener;

import java.awt.event.KeyEvent;

public class MenuInput implements InputListener {

    private Game game;
    private MenuState state;

    public MenuInput(Game game, MenuState state) {
        this.game = game;
        this.state = state;
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        MenuButtons menuButtons = state.getMenuButtons();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S, KeyEvent.VK_D, KeyEvent.VK_DOWN, KeyEvent.VK_RIGHT -> menuButtons.increaseActive();
            case KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_UP, KeyEvent.VK_LEFT -> menuButtons.decreaseActive();
            case KeyEvent.VK_ENTER, KeyEvent.VK_SPACE -> menuButtons.changeState();
            case KeyEvent.VK_ESCAPE -> System.exit(0);
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) { }
}
