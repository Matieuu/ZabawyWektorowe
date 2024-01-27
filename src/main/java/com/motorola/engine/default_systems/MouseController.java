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

public class MouseController extends GameSystem implements MouseInputListener, MouseWheelListener {
    public MouseController(Game mygame){
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
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent mouseEvent) {
    }
}
