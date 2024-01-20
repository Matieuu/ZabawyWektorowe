package com.motorola.engine;
import com.motorola.engine.Vector2;

import java.awt.*;


public class Line2D {
    public Vector2 start;
    public Vector2 end;
    public Color color;

    public Line2D(Vector2 start_, Vector2 end_, Color color_){
        start = start_;
        end = end_;
        color = color_;
    }
}
