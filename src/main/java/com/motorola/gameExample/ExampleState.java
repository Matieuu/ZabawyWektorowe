package com.motorola.gameExample;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

public class ExampleState extends State {

    private GameSystem exampleSystem;

    public ExampleState(Game game) {
        super(game);

        exampleSystem = new ExampleSystem(game);

        new GameObject(game,"Player");
        new GameObject(game,"Object");

        exampleSystem.addObjectByName("Player");
    }

    @Override
    public void update(double delta) {
    }
}
