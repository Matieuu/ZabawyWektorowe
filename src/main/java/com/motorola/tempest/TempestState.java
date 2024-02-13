package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.graphics.*;
import com.motorola.engine.states.State;

import java.awt.*;
import java.util.ArrayList;

public class TempestState extends State {
    private Renderer3D render3d;
    private Model levelHolder;
    public GameObject levelObject;
    public GameObject player;
    public Model playerModel;
    public Camera cameraHolder;
    public TempestInput controller;
    public int game_try = 3;
    public TempestState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        render3d = new Renderer3D(game);

        /**
         * First level defined
         */
        ArrayList<Vector3> vertices = new ArrayList<Vector3>() {
            {
                add(new Vector3(1, 1, 100));
                add(new Vector3(1, 1, -1));
                add(new Vector3(-1, 1, -1));
                add(new Vector3(-1, 1, 100));

                add(new Vector3(1, -1 , 100));
                add(new Vector3(1, -1 , -1));
                add(new Vector3(-1, -1, -1));
                add(new Vector3(-1, -1, 100));
            }
        };
        ArrayList<Line> edges = new ArrayList<Line>() {
            {
                add(new Line(0, 1, Color.BLUE));
                add(new Line(1, 2, Color.BLUE));
                add(new Line(2, 3, Color.BLUE));
                add(new Line(3, 0, Color.BLUE));

                add(new Line(4, 5, Color.BLUE));
                add(new Line(5, 6, Color.BLUE));
                add(new Line(6, 7, Color.BLUE));
                add(new Line(7, 4, Color.BLUE));

                add(new Line(0, 4, Color.BLUE));
                add(new Line(1, 5, Color.BLUE));
                add(new Line(2, 6, Color.BLUE));
                add(new Line(3, 7, Color.BLUE));
            }
        };

        //referencja do modelu levelu
        levelHolder = new Model(vertices, edges, 10);

        /**
         * Model playera
         */
        ArrayList<Vector3> player_vertices = new ArrayList<Vector3>() {
            {
                add(new Vector3(-1, 1, 1));
                add(new Vector3(-1, -1, 1));
                add(new Vector3(1, 1, 1));
                add(new Vector3(1, -1, 1));

                add(new Vector3(0, 0 , 2));
            }
        };
        ArrayList<Line> player_edges = new ArrayList<Line>() {
            {
                add(new Line(0, 1, Color.GREEN));
                add(new Line(3, 1, Color.GREEN));
                add(new Line(2, 3, Color.GREEN));
                add(new Line(0, 2, Color.GREEN));

                add(new Line(0, 4, Color.GREEN));
                add(new Line(1, 4, Color.GREEN));
                add(new Line(2, 4, Color.GREEN));
                add(new Line(3, 4, Color.GREEN));
            }
        };

        playerModel = new Model(player_vertices,player_edges,2);


        /**
         *  make level object
         */
        levelObject = new GameObject(game,"Level");
        levelObject.setValue("Model",levelHolder);
        levelObject.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,0)));

        /**
         * make player object
         */
        player = new GameObject(game,"Player");
        player.setValue("Model", playerModel);
        player.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,0)));

        /**
         * Set the camera to player
         */
        cameraHolder = (Camera) player.setValue("Camera", new Camera(player,0.001));
        render3d.setCamera(cameraHolder);

        /**
         * add object to renderer3d
         */
        render3d.addObject(player);
        render3d.addObject(levelObject);

        /**
         * add input lisener for game and player
         */
        controller = new TempestInput(game,player);
        setInputListener(controller);

        return this;
    }

    @Override
    public void update(double delta) {

    }
}
