package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.InputSystem;
import com.motorola.engine.graphics.Vector2;

import java.awt.*;
import java.awt.event.MouseEvent;

public abstract class ButtonSystem extends GameSystem implements InputSystem {

    private Rectangle bounds;

    private Color color;
    private int round;

    private String content;
    private boolean pressed, hover;

    /**
     * Konstructor for Gamesystem
     *
     * @param mygame
     */
    public ButtonSystem(Game mygame, String content) {
        super(mygame);
        bounds = new Rectangle();
        this.content = content;
        pressed = false;
        hover = false;
    }

    public ButtonSystem setLocalization(Point p) {
        bounds.x = p.x;
        bounds.y = p.y;
        return this;
    }
    public ButtonSystem setLocalization(Vector2 p) {
        bounds.x = (int)p.getX();
        bounds.y = (int)p.getY();
        return this;
    }
    public ButtonSystem setLocalization(int x, int y) {
        bounds.x = x;
        bounds.y = y;
        return this;
    }

    public ButtonSystem setSize(Dimension p) {
        bounds.width = (int)p.getWidth();
        bounds.height = (int)p.getHeight();
        return this;
    }
    public ButtonSystem setSize(Vector2 p) {
        bounds.width = (int)p.getX();
        bounds.height = (int)p.getY();
        return this;
    }
    public ButtonSystem setSize(int x, int y) {
        bounds.width = x;
        bounds.height = y;
        return this;
    }

    public ButtonSystem setBounds(Rectangle rect) {
        bounds = rect;
        return this;
    }
    public ButtonSystem setBounds(Point p, Dimension d) {
        bounds = new Rectangle(p, d);
        return this;
    }
    public ButtonSystem setBounds(int x, int y, Dimension d) {
        bounds = new Rectangle(new Point(x, y), d);
        return this;
    }
    public ButtonSystem setBounds(Point p, int width, int height) {
        bounds = new Rectangle(p, new Dimension(width, height));
        return this;
    }

    public ButtonSystem setColor(Color color) {
        this.color = color;
        return this;
    }
    public ButtonSystem setColor(int r, int g, int b, int a) {
        this.color = new Color(r, g, b, a);
        return this;
    }
    public ButtonSystem setColor(float r, float g, float b, float a) {
        this.color = new Color(r, g, b, a);
        return this;
    }
    public ButtonSystem setColor(int rgba) {
        this.color = new Color(rgba);
        return this;
    }

    public Rectangle getBounds() {
        return bounds;
    }

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
    public void mousePressed(MouseEvent e) {
        if (bounds.contains(e.getX(), e.getY()))
            pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (bounds.contains(e.getX(), e.getY()))
            onClick(e);
        pressed = false;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        hover = bounds.contains(e.getX(), e.getY());
        if (hover) onHover(e);
    }

    public abstract void onClick(MouseEvent e);
    public abstract void onHover(MouseEvent e);
}
