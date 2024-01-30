package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.graphics.*;
import com.motorola.engine.graphics.Line;
import com.motorola.engine.graphics.Vector2;
import com.motorola.engine.graphics.Vector3;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class ButtonsSystem extends GameSystem {

    private Renderer2D renderer;

    private GameObject asteroids;
    private GameObject tempest;
    private GameObject battlezone;

    private int active;

    /**
     * Konstructor for Gamesystem
     *
     * @param game
     */
    public ButtonsSystem(Game game, Renderer2D renderer) {
        super(game);

        asteroids = new GameObject(game, "AsteroidButton");
        tempest = new GameObject(game, "TempestButton");
        battlezone = new GameObject(game, "BattlezoneButton");

        ArrayList<Vector2> vertices = new ArrayList<>() {{
            add(new Vector2(-450, 75));
            add(new Vector2(450, 75));
            add(new Vector2(450, -75));
            add(new Vector2(-450, -75));
        }};

        ArrayList<Line> edges = new ArrayList<>() {{
            add(new Line(0, 1, Color.LIGHT_GRAY));
            add(new Line(1, 2, Color.LIGHT_GRAY));
            add(new Line(2, 3, Color.LIGHT_GRAY));
            add(new Line(3, 0, Color.LIGHT_GRAY));
        }};

        asteroids.setValue("Model2D", new Model2D(vertices, edges, 1));
        asteroids.setValue("Transform", new Transform(new Vector3(0, game.getWindowDimension().height/4, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));

        tempest.setValue("Model2D", new Model2D(vertices, edges, 1));
        tempest.setValue("Transform", new Transform(new Vector3(0, 0, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));

        battlezone.setValue("Model2D", new Model2D(vertices, edges, 1));
        battlezone.setValue("Transform", new Transform(new Vector3(0, -game.getWindowDimension().height/4, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));

        renderer.addObject(asteroids);
        renderer.addObject(tempest);
        renderer.addObject(battlezone);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) { }

    @Override
    public void update(double delta) { }

    @Override
    public void render(Graphics g) { }
}
