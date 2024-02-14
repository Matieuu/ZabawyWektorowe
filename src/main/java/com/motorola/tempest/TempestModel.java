package com.motorola.tempest;

import com.motorola.engine.graphics.Line;
import com.motorola.engine.graphics.Model;
import com.motorola.engine.graphics.Vector3;

import java.awt.*;
import java.util.ArrayList;

public class TempestModel {

    public TempestModel() {}

    public static Model getPlayerMode(int scale) {
        ArrayList<Vector3> player_vertices = new ArrayList<Vector3>() {{
            add(new Vector3(-1, 1, 1));
            add(new Vector3(-1, -1, 1));
            add(new Vector3(1, 1, 1));
            add(new Vector3(1, -1, 1));

            add(new Vector3(0, 0 , 2));
        }};
        ArrayList<Line> player_edges = new ArrayList<Line>() {{
            add(new Line(0, 1, Color.GREEN));
            add(new Line(3, 1, Color.GREEN));
            add(new Line(2, 3, Color.GREEN));
            add(new Line(0, 2, Color.GREEN));

            add(new Line(0, 4, Color.GREEN));
            add(new Line(1, 4, Color.GREEN));
            add(new Line(2, 4, Color.GREEN));
            add(new Line(3, 4, Color.GREEN));
        }};
        return new Model(player_vertices, player_edges, scale);
    }

    public static Model getOldLevelModel(int scale) {
        ArrayList<Vector3> vertices = new ArrayList<>() {{
            add(new Vector3(1, 1, 250));
            add(new Vector3(1, 1, 10));
            add(new Vector3(-1, 1, 10));
            add(new Vector3(-1, 1, 250));

            add(new Vector3(1, -1 , 250));
            add(new Vector3(1, -1 , 10));
            add(new Vector3(-1, -1, 10));
            add(new Vector3(-1, -1, 250));
        }};
        ArrayList<Line> edges = new ArrayList<>() {{
            add(new Line(0, 1, Color.BLUE));
            add(new Line(1, 2, Color.BLUE));
            add(new Line(2, 3, Color.BLUE));
            add(new Line(3, 0, Color.BLUE));

            add(new Line(4, 5, Color.BLUE));
            add(new Line(5, 6, Color.BLUE));
            add(new Line(6, 7, Color.BLUE));
            add(new Line(7, 4, Color.BLUE));

            add(new Line(0, 4, Color.BLUE));
            add(new Line(1, 5, Color.BLUE));
            add(new Line(2, 6, Color.BLUE));
            add(new Line(3, 7, Color.BLUE));

            add(new Line(1, 2, Color.BLUE));
            add(new Line(2, 5, Color.BLUE));
            add(new Line(5, 6, Color.BLUE));
            add(new Line(6, 1, Color.BLUE));
        }};
        return new Model(vertices, edges, scale);
    }

    public static Model getLevelModel(int scale) {
        return new Model(new ArrayList<>(), new ArrayList<>(), 0);
    }
}
