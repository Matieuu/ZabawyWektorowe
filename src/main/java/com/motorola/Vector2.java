package com.motorola;

/**
 * Wektor dwuwymiarowy
 */
public class Vector2 {

    public float x, y;

    /**
     * Konstruktor
     * @param x x
     * @param y y
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter dla x
     * @return x
     */
    public float getX() {
        return x;
    }

    /**
     * Getter dla y
     * @return y
     */
    public float getY() {
        return y;
    }

    /**
     * Potęguje x i y oraz dodaje do siebie
     * @return x^2 + y^2
     */
    public float squaredMagnitude() {
        return (float) Math.pow(x, 2) + (float) Math.pow(y, 2);
        //return 0.0f; //TODO
    }

    /**
     * Długość wektora
     * @return Długość wektora
     */
    public float magnitude() {
        return squaredMagnitude();
    }
}
