package com.motorola.engine;

import com.motorola.engine.default_systems.Renderer2D;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Komponent zawierający dane o tym jak wyświetlać obiekt na ekranie
 */
public class Model2D {
    /**
     * Lista zawierająca wszystkie Line2D linie
     */
    private ArrayList<Line2D> lines;
    /**
     * Skalar pozwalający na wybranie rozmiaru obiektu w świecie gry
     */
    private double scale = 1f; //TODO zamienic double na Vector2 tak zeby mozna bylo osobno skalowac w dwoch plaszczyznach
    /**
     * Zwraca wartość scale
     */
    public double getScale() {
        return scale;
    }
    /**
     * Ustawia wartość scale
     * @param scale scale
     */
    public void setScale(double scale) {
        this.scale = scale;
    }
    /**
     * Konstruktor
     * @param lines Lista linii Line2D które skladają się na model
     */
    public Model2D(ArrayList<Line2D> lines) {
        this.lines = lines;
    }
    /**
     * Konstruktor
     * @param lines Lista linii Line2D które skladają się na model
     * @param scale scale
     */
    public Model2D(ArrayList<Line2D> lines, double scale) {
        this.lines = lines;
        this.scale = scale;
    }
    /**
     * Zwraca gotową listę linii Line2D uwzględniając skalowanie i obrót
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
