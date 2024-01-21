package com.motorola.engine.graphics;

import java.util.ArrayList;

/**
 * Komponent zawierajacy dane o tym jak wyswietlac obiekt na ekranie
 */
public class Model2D {
    /**
     * Lista zawierajaca wszystkie Line2D linie
     */
    private ArrayList<Line2D> lines;
    /**
     * Skalar pozwalajacy na wybranie rozmiaru obiektu w swiecie gry
     */
    private double scale = 1f; //TODO zamienic double na Vector2 tak zeby mozna bylo osobno skalowac w dwoch plaszczyznach
    /**
     * Zwraca wartosc scale
     */
    public double getScale() {
        return scale;
    }
    /**
     * Ustawia wartosc scale
     * @param scale scale
     */
    public void setScale(double scale) {
        this.scale = scale;
    }
    /**
     * Konstruktor
     * @param lines Lista linii Line2D ktore skladaja sie na model
     */
    public Model2D(ArrayList<Line2D> lines) {
        this.lines = lines;
    }
    /**
     * Konstruktor
     * @param lines Lista linii Line2D ktore skladaja sie na model
     * @param scale scale
     */
    public Model2D(ArrayList<Line2D> lines, double scale) {
        this.lines = lines;
        this.scale = scale;
    }
    /**
     * Zwraca gotowa liste linii Line2D uwzgledniajac skalowanie i obrot
     */
    public ArrayList<Line2D> getModel(Quaternion rotation) {
        ArrayList<Line2D> model = new ArrayList<>();

        for (Line2D line : lines) {
            model.add(new Line2D(
                    Quaternion.rotatePoint(line.start, rotation).multiply(scale),
                    Quaternion.rotatePoint(line.end, rotation).multiply(scale),
                    line.color));
        }
        return model;
    }
}
