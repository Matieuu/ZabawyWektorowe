package com.motorola.gameExample;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

public class ExampleState extends State {

    private GameSystem exampleSystem;
    private Renderer2D renderer;

    public ExampleState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        exampleSystem = new ExampleSystem(game);
        renderer = new Renderer2D(game);

        new GameObject(game,"Player");
        new GameObject(game,"Object");

        exampleSystem.addObjectsByName("Player");

        return this;
    }

    @Override
    public void update(double delta) {
    }
}
