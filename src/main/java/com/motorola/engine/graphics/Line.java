package com.motorola.engine.graphics;

import java.awt.*;


public class Line {
    /**
     * Index of start vertex
     */
    final private int start;
    /**
     * Index of end vertex
     */
    final private int end;
    /**
     * Color of connection between
     */
    final private Color color;

    public int getStart() {
        return start;
    }

    public int getEnd() {
        return end;
    }

    public Color getColor() {
        return color;
    }

    public Line(int start, int end, Color color) {
        this.start = start;
        this.end = end;
        this.color = color;
    }
}
