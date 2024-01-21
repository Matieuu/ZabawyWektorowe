package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.states.State;

import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseControler extends GameSystem implements MouseInputListener, MouseWheelListener {
    public MouseControler(Game mygame){
        super(mygame);
        mygame.getPanel().addMouseListener(this);
        mygame.getPanel().addMouseMotionListener(this);
        mygame.getPanel().addMouseWheelListener(this);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {

    }

    @Override
    public void update(double delta){

    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseClicked(mouseEvent);
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mousePressed(mouseEvent);
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseReleased(mouseEvent);
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseEntered(mouseEvent);
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseExited(mouseEvent);
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseDragged(mouseEvent);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseMoved(mouseEvent);
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseEvent) {
        State state = mygame.getStateManager().peek();
        if (!(state instanceof InputSystem)) return;
        ((InputSystem) state).mouseWheelMoved(mouseEvent);
    }
}
