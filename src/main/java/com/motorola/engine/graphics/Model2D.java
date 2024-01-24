package com.motorola.engine.graphics;

import java.util.ArrayList;

/**
 * Komponent zawierajacy dane o tym jak wyswietlac obiekt na ekranie
 */
public class Model2D {
    /**
     * Returns all Vector2 verticies positions
     */
    private ArrayList<Vector2> vertices;
    private ArrayList<Line> edges;
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

    public ArrayList<Vector2> getVerticies() {
        return vertices;
    }

    public void setVertices(ArrayList<Vector2> verticies) {
        this.vertices = verticies;
    }

    public ArrayList<Line> getEdges() {
        return edges;
    }

    public void setEdges(ArrayList<Line> edges) {
        this.edges = edges;
    }

    /**
     * Konstruktor
     * @param vertices Lista linii Line2D ktore skladaja sie na model
     * @param scale scale
     */

    public Model2D(ArrayList<Vector2> vertices, ArrayList<Line> edges, double scale) {
        this.vertices = vertices;
        this.edges = edges;
        this.scale = scale;
    }

    @Override
    public String toString() {
        return "Model2D (vertices: " + vertices.size() +")";
    }
}