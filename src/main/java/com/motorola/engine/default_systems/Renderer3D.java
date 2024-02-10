package com.motorola.engine.default_systems;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.graphics.*;
import com.motorola.engine.graphics.Line;
import com.motorola.engine.graphics.Vector2;
import com.motorola.engine.graphics.Vector3;

import java.awt.*;
import java.util.ArrayList;

public class Renderer3D extends GameSystem {

    private Camera camera;
    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public Renderer3D(Game game){
        super(game);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }

    @Override
    public void update(double delta){

    }

    @Override
    public void render(Graphics g) {
        //preparing important camera properties
        Vector3 cameraInversedPosition = ((Transform)(camera.getGameObject().getValue("Transform"))).getPosition().multiply(-1);
        Quaternion cameraInversedRotation = ((Transform)(camera.getGameObject().getValue("Transform"))).getRotation().conjugate();
        double focalLength = camera.getFocalLength();
        double halfScreenWidth = game.getWindowDimension().width*0.5;
        double projectionMultiplier = camera.getProjectionMultiplier();

        for (GameObject obj : usedObjects) {
            Transform transform = (Transform) obj.getValue("Transform");
            Vector3 position = transform.getPosition();
            Quaternion rotation = transform.getRotation();
            Model model = (Model) obj.getValue("Model");
            double scale = model.getScale();

            //making vertices relative to camera (including rotation of camera and them
            ArrayList<Vector3> relativeToCameraVertices = new ArrayList<>();
            for (Vector3 vertex : model.getVertices()) { //for every vertex
                relativeToCameraVertices.add(
                        Quaternion.rotatePoint( //including camera rotation
                                Quaternion.rotatePoint(vertex, rotation) //including object rotation
                                        //.multiply(scale) //including scale
                                        .add(position) //including object position
                                        .add(cameraInversedPosition), //including camera position
                                cameraInversedRotation //including camera rotation
                ));
            }

            //making list of 2D positions of vertices on screen
            ArrayList<Vector2> projectedVertices = new ArrayList<>();
            for (Vector3 vertex : relativeToCameraVertices) {
                projectedVertices.add(
                        new Vector2(
                                vertex.getX()/vertex.getZ()*focalLength,
                                vertex.getY()/vertex.getZ()*focalLength
                        )
                                .multiply(projectionMultiplier)
                );
            }

            //drawing lines on screen
            for (Line edge : model.getEdges()) {
                Vector2 rawStart = projectedVertices.get(edge.getStart());
                Vector2 start = new Vector2(rawStart.getX(), -rawStart.getY())
                        .multiply(model.getScale())
                        .add(new Vector2((double) game.getWindowDimension().width/2, (double) game.getWindowDimension().height/2))
                        .add(new Vector2(position.getX(), -position.getY()));
                Vector2 rawEnd = projectedVertices.get(edge.getEnd());
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
