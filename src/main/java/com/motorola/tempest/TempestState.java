package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.states.State;

public class TempestState extends State {

    private Renderer3D render3d;
    private LevelControlerSystem levelControlerSystem;

    public TempestState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        render3d = new Renderer3D(game);
        levelControlerSystem = new LevelControlerSystem(game,render3d);

        return this;
    }

    @Override
    public void update(double delta) {

    }
}
