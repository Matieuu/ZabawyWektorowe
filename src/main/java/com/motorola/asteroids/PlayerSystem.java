package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class PlayerSystem extends GameSystem {

    private Renderer2D renderer;
    private GameObject player;

    private long shootDelay;
    private long lastShot;

    /**
     * Konstructor for Gamesystem
     *
     * @param game
     */
    public PlayerSystem(Game game, Renderer2D renderer) {
        super(game);
        game.removeGameSystem(this);
        this.renderer = renderer;
        createPlayer(100);
        shootDelay = 2000000000;
        lastShot = System.nanoTime() - shootDelay;
        game.addGameSystem(this);
    }

    private void onMoveForward() { }

    private void onMoveBackward() { }

    private void onMoveLeft() {
        Transform transform = (Transform) player.getValue("Transform");
        transform.setRotation(Quaternion.createEulerAngles(
                transform.getRotation().getX(),
                transform.getRotation().getY(),
                transform.getRotation().getZ() + Math.PI/180
        ));
        player.setValue("Transform", transform);
    }

    private void onMoveRight() {
        Transform transform = (Transform) player.getValue("Transform");
        transform.setRotation(Quaternion.createEulerAngles(
                transform.getRotation().getX(),
                transform.getRotation().getY(),
                transform.getRotation().getZ() - Math.PI/180
        ));
        player.setValue("Transform", transform);
    }

    private void onShoot() {
        long currentTime = System.nanoTime();
        if (currentTime - shootDelay < lastShot) return;

        // strzał
    }

    @Override
    public void render(Graphics g) {

    }

    @Override
    public void update(double delta) {
        if ((boolean) player.getValue("moveForward"))
            onMoveForward();
        if ((boolean) player.getValue("moveBackward"))
            onMoveBackward();
        if ((boolean) player.getValue("moveLeft"))
            onMoveLeft();
        if ((boolean) player.getValue("moveRight"))
            onMoveRight();
        if ((boolean) player.getValue("shoot"))
            onShoot();
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

    @Override
    public void addToGameObjectValues(GameObject gameObject) { }

    public GameObject getPlayer() {
        return player;
    }
}
