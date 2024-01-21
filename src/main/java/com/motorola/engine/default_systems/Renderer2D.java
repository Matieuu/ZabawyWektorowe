package com.motorola.engine.default_systems;

import com.motorola.engine.*;
import com.motorola.engine.graphics.Line2D;
import com.motorola.engine.graphics.Model2D;
import com.motorola.engine.graphics.Transform;

import java.awt.*;
import java.util.ArrayList;


public class Renderer2D extends GameSystem {
    //todo camera
    Graphics g;
    private ArrayList<GameObject> objectsToRender = new ArrayList<>();
    public Renderer2D(Game mygame){
        super(mygame);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }
    public void addObject(GameObject object) {
        objectsToRender.add(object);
    }
    public void deleteObject(GameObject object) {
        objectsToRender.remove(object);
    }
    @Override
    public void update(double delta){
    }

    @Override
    public void render(Graphics g) {
        for (GameObject obj : objectsToRender) {
            Model2D model = (Model2D) obj.getValue("Model2D");
            for (Line2D line : model.getModel(((Transform)obj.getValue("Transform")).getRotation())) {
                g.setColor(line.color);
                g.drawLine((int) line.start.getX(), (int) line.start.getY(), (int) line.end.getX(), (int) line.end.getY());
            }
        }
    }
}
