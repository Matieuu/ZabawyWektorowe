package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.graphics.*;
import com.motorola.engine.states.State;

import java.util.ArrayList;

public class TempestState extends State {

    private Renderer3D render3d;
    private Camera cameraHolder;
    private TempestInput controller;

    private GameObject camera;
    private GameObject levelObject;
    private GameObject player;
    private Model levelHolder;
    private ArrayList<Integer> edges_to_move_for_player;//LOL
    private Model playerModel;

    private int game_try = 3;
    private double angle = 0;

    public TempestState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        render3d = new Renderer3D(game);

        levelHolder = TempestModel.getOldLevelModel(10);
        playerModel = TempestModel.getPlayerMode(2);

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
        player.setValue("Transform", new Transform(new Vector3(0,0,1), Quaternion.createEulerAngles(0,0,0)));

        /**
         * Set the camera to player
         */
        camera = new GameObject(game,"CameraHolder");
        camera.setValue("Transform", new Transform(new Vector3(0,0,-10), Quaternion.createEulerAngles(0,0,0)));
        cameraHolder = new Camera(camera,0.1);
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
        if (controller == null) return;

        controller.update(delta);
        Transform transform = (Transform) player.getValue("Transform");

        if ((boolean) player.getValue("moveLeft")) {
            angle -= Math.PI/8 * delta;
            transform.setRotation(Quaternion.createEulerAngles(0, angle, 0));
        }

        if ((boolean) player.getValue("moveRight")) {
            angle += Math.PI/8 * delta;
            transform.setRotation(Quaternion.createEulerAngles(0, angle, 0));
        }

        if (angle > 2*Math.PI) angle -= 2*Math.PI;
        if (angle < 0) angle += 2*Math.PI;
    }
}
