package com.motorola.engine.graphics;

import java.util.ArrayList;

public class Model {
    private ArrayList<Vector3> vertices;
    private ArrayList<Line> edges;
    /**
     * Skalar pozwalajacy na wybranie rozmiaru obiektu w swiecie gry
     */
    private double scale = 1f; //TODO zamienic double na Vector3 tak zeby mozna bylo osobno skalowac w dwoch plaszczyznach

    /**
     * Konstruktor
     * @param vertices Lista linii Line2D ktore skladaja sie na model
     * @param scale scale
     */
    public Model(ArrayList<Vector3> vertices, ArrayList<Line> edges, double scale) {
        this.vertices = vertices;
        this.edges = edges;
        this.scale = scale;
    }

    /**
     * Zwraca wartosc scale
     */
    public double getScale() {
        return scale;
    }
    public ArrayList<Vector3> getVerticies() {
        return vertices;
    }
    public ArrayList<Line> getEdges() {
        return edges;
    }

    /**
     * Ustawia wartosc scale
     * @param scale scale
     */
    public void setScale(double scale) {
        this.scale = scale;
    }
    public void setVertices(ArrayList<Vector3> verticies) {
        this.vertices = verticies;
    }
    public void setEdges(ArrayList<Line> edges) {
        this.edges = edges;
    }

    @Override
    public String toString() {
        return "Model2D (vertices: " + vertices.size() +")";
    }
}
