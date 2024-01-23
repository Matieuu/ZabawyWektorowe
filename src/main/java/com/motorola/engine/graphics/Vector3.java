package com.motorola.engine.graphics;

/**
 * Wektor trojwymiarowy
 */
public class Vector3 {
    private double x, y, z;

    /**
     * Konstruktor
     * @param x x
     * @param y y
     * @param z z
     */
    public Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;

    }
    /**
     * Getter dla z
     * @return z
     */
    public double getX() {
        return x;
    }
    /**
     * Getter dla z
     * @return z
     */
    public double getY() {
        return y;
    }
    /**
     * Getter dla z
     * @return z
     */
    public double getZ() {
        return z;
    }
    /**
     * Zwraca kwadrat dlugosci wektora
     * @return x^2 + y^2 + z^2
     */
    public double squaredMagnitude() {
        return x*x+y*y+z*z;
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
    public Vector3 normalized() {
        return this.multiply(1/Math.sqrt(squaredMagnitude()));
    }
    public Vector3 add(Vector2 other) {
        return new Vector3(x + other.getX(), y + other.getY(), z);
    }
    public Vector3 add(Vector3 other) {
        return new Vector3(x + other.getX(), y + other.getY(), z + other.getZ());
    }
    public Vector3 multiply(double multiplier) {
        return new Vector3(x*multiplier, x*multiplier, z*multiplier);
    }
    @Override
    public String toString() {
        return "(" + x + ", " + y + ", " + z + ")";
    }
    // statics
    /**
     * Skrot dla new Vector3(0f, 1f, 0f)
     */
    public static Vector3 up = new Vector3(0, 1, 0);
    /**
     * Skrot dla new Vector3(1f, 0f, 0f)
     */
    public static Vector3 right = new Vector3(1, 0, 0);
    /**
     * Skrot dla new Vector3(0f, 0f, 1f)
     */
    public static Vector3 forward = new Vector3(0, 0, 1);
    /**
     * Skrot dla new Vector3(0f, 0f, 0f)
     */
    public static Vector3 zero = new Vector3(0, 0, 0);
}
