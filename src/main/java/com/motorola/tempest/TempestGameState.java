package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.Renderer3D;
import com.motorola.engine.states.State;

public class TempestGameState extends State {

    private Renderer3D render3d;
    private LevelControlerSystem levelControlerSystem;
    TempestGameState(Game game){
        super(game);

        render3d = new Renderer3D(game);

        levelControlerSystem = new LevelControlerSystem(game,render3d);



    }

    @Override
    public void update(double delta) {

    }
}
