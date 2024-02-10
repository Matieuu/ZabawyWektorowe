package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.InputListener;

import java.awt.event.KeyEvent;

public class AsteroidsInput implements InputListener {

    private Game game;

    public AsteroidsInput(Game game){
        this.game = game;
    }

    public void onKeyPress(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE -> game.getStateManager().pop();
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> game.getObjectsByName("Player"); //Przesunięcie o jedną "jednostkę" w lewo
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> game.getObjectsByName("Player"); //Przesunięcie o jedną "jednostkę" w prawo
            case KeyEvent.VK_BACK_SPACE -> game.getObjectsByName("Bullet"); //wystrzał
        }
    }
    public void onKeyRelease(KeyEvent e){
        switch(e.getKeyCode()){
            case KeyEvent.VK_ESCAPE -> game.getStateManager().pop();
            case KeyEvent.VK_LEFT, KeyEvent.VK_A -> game.getObjectsByName("Player"); //Przesunięcie o jedną "jednostkę" w lewo
            case KeyEvent.VK_RIGHT, KeyEvent.VK_D -> game.getObjectsByName("Player"); //Przesunięcie o jedną "jednostkę" w prawo
        }
    }
}
