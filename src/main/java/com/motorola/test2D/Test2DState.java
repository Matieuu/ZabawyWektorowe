package com.motorola.test2D;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.graphics.*;
import com.motorola.engine.states.State;

import java.awt.*;
import java.util.ArrayList;

public class Test2DState extends State {
    final private GameSystem renderer;
    public Test2DState(Game game) {
        super(game);

        renderer = new Renderer2D(game);

        GameObject player = new GameObject(game,"Player");
        System.out.print(player + "\n");
        player.setValue("Transform", new Transform(new Vector3(0,0,0), Quaternion.createEulerAngles(0,0,Math.PI/2)));
        System.out.print(player.getValue("Transform") + "\n");
        ArrayList<Vector2> vertices = new ArrayList<Vector2>() {
            {
                add(new Vector2(-1, 1));
                add(new Vector2(1, 1));
                add(new Vector2(1, -1));
                add(new Vector2(-1, -1));
            }
        };
        ArrayList<Line> edges = new ArrayList<Line>() {
            {
                add(new Line(0, 1, Color.BLACK));
                add(new Line(1, 2, Color.BLACK));
                add(new Line(2, 3, Color.BLACK));
                add(new Line(3, 0, Color.BLACK));
                add(new Line(0, 2, Color.BLACK));
            }
        };

        player.setValue("Model2D", new Model2D(vertices, edges, 100));
        System.out.print(player.getValue("Model2D") + "\n");

        renderer.addObjectByName("Player");

    }
    @Override
    public void update(double delta) {

    }
}
