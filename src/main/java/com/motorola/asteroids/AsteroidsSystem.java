package com.motorola.asteroids;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class AsteroidsSystem extends GameSystem {

    private GameObject player;

    private float asteroidDelay;
    private float currentAsteroidDelay;

    public AsteroidsSystem(Game mygame, GameObject player) {
        super(mygame);

        this.player = player;
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) { }

    @Override
    public void update(double delta) { }

    @Override
    public void render(Graphics g) { }


    public Model2D createAsteroid(){
        ArrayList<Vector2>points = new ArrayList<>(){{
            add(new Vector2(-100, 0));
            add(new Vector2(0, 25));
            add(new Vector2(100, 0));
            add(new Vector2(0, 100));
            add(new Vector2(-100, 0));
        }};
        ArrayList<Line>edges = new ArrayList<>(){{
            add(new Line(0,1, Color.ORANGE));
            add(new Line(1, 2, Color.ORANGE));
            add(new Line(2,3, Color.ORANGE));
            add(new Line(3, 4, Color.ORANGE));
            add(new Line(4,5, Color.ORANGE));
        }};

        return new Model2D(points,edges,1);
    }
}
