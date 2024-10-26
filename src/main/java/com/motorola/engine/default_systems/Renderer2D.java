package com.motorola.engine.default_systems;

import com.motorola.engine.*;
import com.motorola.engine.graphics.*;
import com.motorola.engine.graphics.Line;
import com.motorola.engine.graphics.Vector2;
import com.motorola.engine.graphics.Vector3;

import java.awt.*;
import java.util.ArrayList;


public class Renderer2D extends GameSystem {
    //todo camera
    public Renderer2D(Game mygame){
        super(mygame);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }

    @Override
    public void update(double delta){
    }

    @Override
    public void render(Graphics g) {
        for (GameObject obj : usedObjects) {
            Transform transform = (Transform) obj.getValue("Transform");
            Vector3 position = transform.getPosition();
            Model2D model = (Model2D) obj.getValue("Model2D");
            ArrayList<Vector2> vertices = model.getVertices();

            for (Line edge : model.getEdges()) {
                Vector2 rawStart = Quaternion.rotatePoint(vertices.get(edge.getStart()), transform.getRotation());
                Vector2 start = new Vector2(rawStart.getX(), -rawStart.getY())
                        .multiply(model.getScale())
                        .add(new Vector2((double) game.getWindowDimension().width/2, (double) game.getWindowDimension().height/2))
                        .add(new Vector2(position.getX(), -position.getY()));
                Vector2 rawEnd = Quaternion.rotatePoint(vertices.get(edge.getEnd()), transform.getRotation());
                Vector2 end = new Vector2(rawEnd.getX(), -rawEnd.getY())
                        .multiply(model.getScale())
                        .add(new Vector2((double) game.getWindowDimension().width/2, (double) game.getWindowDimension().height/2))
                        .add(new Vector2(position.getX(), -position.getY()));
                g.setColor(edge.getColor());
                g.drawLine(
                        (int)start.getX(), (int)start.getY(),
                        (int)end.getX(), (int)end.getY()
                );

            }
        }
    }
}
