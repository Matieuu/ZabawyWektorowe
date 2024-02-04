package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.InputListener;
import com.motorola.engine.states.State;

import java.awt.event.KeyEvent;

public class MenuInputListener implements InputListener {

    private Game game;
    private MenuState state;

    public MenuInputListener(Game game, MenuState state) {
        this.game = game;
        this.state = state;
    }

    @Override
    public void onKeyPress(KeyEvent e) {
        MenuButtons menuButtons = state.getMenuButtons();

        switch (e.getKeyCode()) {
            case KeyEvent.VK_S:
            case KeyEvent.VK_D:
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_RIGHT:
                menuButtons.increaseActive();
                break;
            case KeyEvent.VK_W:
            case KeyEvent.VK_A:
            case KeyEvent.VK_UP:
            case KeyEvent.VK_LEFT:
                menuButtons.decreaseActive();
                break;
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_SPACE:
                menuButtons.changeState();
                break;
            case KeyEvent.VK_ESCAPE:
                System.exit(0);
                break;
        }
    }

    @Override
    public void onKeyRelease(KeyEvent e) { }
}
