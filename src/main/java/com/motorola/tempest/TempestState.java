package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.graphics.Model;
import com.motorola.engine.graphics.Quaternion;
import com.motorola.engine.graphics.Transform;
import com.motorola.engine.graphics.Vector3;
import com.motorola.engine.states.State;

public class TempestState extends State {

    private Renderer3D render3d;
    private Model firstLevel;
    public GameObject levelObject;
    public GameObject player;

    public TempestState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        render3d = new Renderer3D(game);

        levelObject = new GameObject(game,"Level");
        levelObject.setValue("Model",firstLevel);
        levelObject.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,0)));

        render3d.addObject(levelObject);
        player = new GameObject(game,"Player");
        levelObject.setValue("Model", firstLevel);
        levelObject.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,0)));
        render3d.addObject(player);

        return this;
    }

    @Override
    public void update(double delta) {

    }
}
