package com.motorola.engine.graphics;

/**
 * Wektor dwuwymiarowy
 */
public class Vector2 {
    private double x, y;

    /**
     * Konstruktor
     * @param x x
     * @param y y
     */
    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    /**
     * Getter dla x
     * @return x
     */
    public double getX() {
        return x;
    }

    /**
     * Getter dla y
     * @return y
     */
    public double getY() {
        return y;
    }

    /**
     * Zwraca kwadrat dlugosci wektora
     * @return x^2 + y^2
     */
    public double squaredMagnitude() {
        return x*x+y*y;
    }

    /**
     * Dlugosc wektora
     * @return Dlugosc wektora
     */
    public double magnitude() {
        return Math.sqrt(squaredMagnitude());
    }
    /**
     * Zwraca wektor o tym samym kierunku ale dlugosci 1
     */
    public Vector2 normalized() {
        return this.multiply(1/Math.sqrt(squaredMagnitude()));
    }
    /**
     * Szybkie rzutowanie do Vector3
     */
    public Vector3 vector3() {
        return new Vector3(this.x, this.y,0);
    }
    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.getX(), this.y + other.getY());
    }
    public void increase(Vector2 other) {
        x += other.getX();
        y += other.getY();
    }
    public Vector2 multiply(double multiplier) {
        return new Vector2(this.x*multiplier, this.y*multiplier);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
    // statics
    /**
     * Skrot dla new Vector2(0, 1)
     */
    public static Vector2 up = new Vector2(0, 1);
    /**
     * Skrot dla new Vector2(1, 0)
     */
    public static Vector2 right = new Vector2(1, 0);
    /**
     * Skrot dla new Vector2(0, 0)
     */
    public static Vector2 zero = new Vector2(0, 0);
}
