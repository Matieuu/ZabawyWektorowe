package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AsteroidsSystem extends GameSystem {

    public float asteroidDelay;
    public float currentAsteroidDelay;

    private ArrayList<Vector2> points;
    private ArrayList<Line> edges;
    public KeyEvent click;
    public GameObject player;
    public AsteroidsSystem(Game mygame){


        super(mygame);
        points = new ArrayList<>(){{
            add(new Vector2(-100, 0));
            add(new Vector2(0, 25));
            add(new Vector2(100, 0));
            add(new Vector2(0, 100));
            add(new Vector2(-100, 0));
        }};
        edges = new ArrayList<>(){{
            add(new Line(0,1, Color.ORANGE));
            add(new Line(1, 2, Color.ORANGE));
            add(new Line(2,3, Color.ORANGE));
            add(new Line(3, 4, Color.ORANGE));
            add(new Line(4,5, Color.ORANGE));
        }};
        player.setValue("Model2D", new Model2D(points, edges, 1));
        player.setValue("Transform", new Transform(new Vector2(Window.WIDTH/2, 50), Quaternion.createEulerAngles(0, 0, 0)));
        this.addObjectsByName("*Asteroid");
        this.addObjectsByName("Player");
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
    }

    @Override
    public void update(double delta) {
        if (asteroidDelay > currentAsteroidDelay){
            currentAsteroidDelay += delta;
        }
        else{
            new GameObject(game,"Asteroid");
        }
    }

    @Override
    public void render(Graphics g) {

    }

}
