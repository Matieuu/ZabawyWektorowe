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

    private AsteroidsSystem asteroidsSystem;
    private ColisionsSystem colisionsSystem;

    private GameObject player;

    public AsteroidState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        renderer = new Renderer2D(game);
        createPlayer(100);

        asteroidsSystem = new AsteroidsSystem(game, player);
        colisionsSystem = new ColisionsSystem(game);

        controller = new AsteroidsInput(game, player);
        setInputListener(controller);
        return this;
    }

    @Override
    public void update(double delta) {
        if (controller == null) return;
        controller.update(delta);

        if ((boolean) player.getValue("moveForward")) {
            Vector2 speed = (Vector2) player.getValue("speed");
            double acceleration = (double) player.getValue("acceleration");
        }
    }

    public void createPlayer(int scale) {
        player = new GameObject(game,"Player");

        ArrayList<Vector2> points = new ArrayList<>() {{
            add(new Vector2(1./8, 3./5));
            add(new Vector2(0, 1));
            add(new Vector2(-1./8, 3./5));
            add(new Vector2(1./12, (-16./5)*(1./12)+1));
            add(new Vector2(-1./12, (16./5)*(-1./12)+1));
            add(new Vector2(0, .5));
        }};
        ArrayList<Line> edges = new ArrayList<>() {{
            add(new Line(0, 1, Color.ORANGE));
            add(new Line(1, 2, Color.ORANGE));
            add(new Line(3, 4, Color.ORANGE));
            add(new Line(4, 5, Color.ORANGE));
            add(new Line(3, 5, Color.ORANGE));
        }};

        player.setValue("Model2D", new Model2D(points, edges, scale));
        player.setValue("Transform", new Transform(new Vector2(0, -scale/2.), Quaternion.createEulerAngles(0, 0, 0)));

        player.setValue("acceleration", 0.5);
        player.setValue("speed", new Vector2(0, 0));

        renderer.addObject(player);
    }
}
