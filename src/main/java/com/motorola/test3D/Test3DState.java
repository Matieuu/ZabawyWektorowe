package com.motorola.test3D;

import com.motorola.engine.*;
import com.motorola.engine.default_systems.*;
import com.motorola.engine.graphics.*;
import com.motorola.engine.graphics.Line;
import com.motorola.engine.graphics.Vector3;
import com.motorola.engine.states.*;

import java.awt.*;
import java.util.ArrayList;

public class Test3DState extends State {

    private Renderer3D renderer;
    private Camera camera;

    double angle = 0;

    public Test3DState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        renderer = new Renderer3D(game);

        GameObject player = new GameObject(game,"Player");
        GameObject cube = new GameObject(game, "Cube");

        player.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,0)));
        cube.setValue("Transform", new Transform(new Vector3(0,0,2.0), Quaternion.createEulerAngles(0,0,0)));

        ArrayList<Vector3> vertices = new ArrayList<Vector3>() {
            {
                add(new Vector3(1, 1, 1));
                add(new Vector3(1, 1, -1));
                add(new Vector3(-1, 1, -1));
                add(new Vector3(-1, 1, 1));

                add(new Vector3(1, -1 , 1));
                add(new Vector3(1, -1 , -1));
                add(new Vector3(-1, -1, -1));
                add(new Vector3(-1, -1, 1));
            }
        };
        ArrayList<Line> edges = new ArrayList<Line>() {
            {
                add(new Line(0, 1, Color.YELLOW));
                add(new Line(1, 2, Color.YELLOW));
                add(new Line(2, 3, Color.YELLOW));
                add(new Line(3, 0, Color.YELLOW));

                add(new Line(4, 5, Color.BLUE));
                add(new Line(5, 6, Color.BLUE));
                add(new Line(6, 7, Color.BLUE));
                add(new Line(7, 4, Color.BLUE));

                add(new Line(0, 4, Color.GREEN));
                add(new Line(1, 5, Color.RED));
                add(new Line(2, 6, Color.RED));
                add(new Line(3, 7, Color.GREEN));
            }
        };

        ArrayList<Vector3> tileVertices = new ArrayList<Vector3>() {
            {
                add(new Vector3(1, 0, 1));
                add(new Vector3(1, 0, -1));
                add(new Vector3(-1, 0, -1));
                add(new Vector3(-1, 0, 1));
            }
        };
        ArrayList<Line> tileEdges = new ArrayList<Line>() {
            {
                add(new Line(0, 2, Color.WHITE));
            }
        };

        cube.setValue("Model", new Model(vertices, edges, 1));
        System.out.print("Cube model: " + cube.getValue("Model") + "\n");


        camera = (Camera) player.setValue("Camera", new Camera(player,Math.PI/3,0.001));
        ((Renderer3D) renderer).addObject(cube);
        ((Renderer3D) renderer).setCamera((Camera)player.getValue("Camera"));

        return this;
    }

    @Override
    public void update(double delta) {
        Transform transform = ((Transform) game.getObjectsByName("Cube").get(0).getValue("Transform"));
        angle += Math.PI/8 * delta;
        transform.setRotation(Quaternion.createEulerAngles(0,angle,0));
        //transform.setPosition(new Vector3(10,0,transform.getPosition().getZ()+1*delta));
        //System.out.print(transform.getRotation().getEulerAnglesRadians() + "\n");
    }
}
