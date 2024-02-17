package com.motorola.asteroids;
import com.motorola.engine.*;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.graphics.*;
import com.motorola.engine.states.State;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class AsteroidState extends State {

    private Renderer2D renderer;
    private AsteroidsInput controller;

    private PlayerSystem playerSystem;
    private AsteroidsSystem asteroidsSystem;
    private ColisionsSystem colisionsSystem;

    private GameObject player;

    public AsteroidState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        renderer = new Renderer2D(game);

        playerSystem = new PlayerSystem(game, renderer);
        asteroidsSystem = new AsteroidsSystem(game, player);
        colisionsSystem = new ColisionsSystem(game);
        player = playerSystem.getPlayer();

        controller = new AsteroidsInput(game, player);
        setInputListener(controller);
        return this;
    }

    @Override
    public void update(double delta) {
        if (controller == null) return;
        controller.update(delta);
    }
}
