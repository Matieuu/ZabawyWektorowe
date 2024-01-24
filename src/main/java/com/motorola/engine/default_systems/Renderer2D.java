package com.motorola.engine.default_systems;

import com.motorola.engine.*;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.util.ArrayList;


public class Renderer2D extends GameSystem {
    //todo camera
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
            Transform transform = (Transform) obj.getValue("Transform");
            Vector3 position = transform.getPosition();
            Model2D model = (Model2D) obj.getValue("Model2D");
            ArrayList<Vector2> vertices = model.getVerticies();

            for (Line edge : model.getEdges()) {
                Vector2 start = vertices.get(edge.getStart())
                        .add(new Vector2(position.getX(), position.getY()))
                        .add(new Vector2((double) mygame.getWindowDimension().width/2, (double) mygame.getWindowDimension().height/2));
                Vector2 end = vertices.get(edge.getEnd())
                        .add(new Vector2(position.getX(), position.getY()))
                        .add(new Vector2((double) mygame.getWindowDimension().width/2, (double) mygame.getWindowDimension().height/2));
                System.out.print("start: " + start + " >>> ");
                System.out.print("end: " + end + "\n");
                g.setColor(edge.getColor());
                g.drawLine(
                        (int)start.getX(), (int)start.getY(),
                        (int)end.getX(), (int)end.getY()
                );

            }
        }
        g.setColor(Color.BLACK);
        g.drawLine(0,0,mygame.getWindowDimension().width,mygame.getWindowDimension().height);
    }
}
