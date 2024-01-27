package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class Renderer3D extends GameSystem {
    private ArrayList<GameObject> objectsToRender = new ArrayList<>();
    public Renderer3D(Game mygame){
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
            Model model = (Model) obj.getValue("Model");
            ArrayList<Vector3> vertices = model.getVerticies();

            for (Line edge : model.getEdges()) {
                
            }
        }
    }
}
