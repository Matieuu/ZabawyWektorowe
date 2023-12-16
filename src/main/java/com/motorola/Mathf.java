package com.motorola;

import java.util.Random;

/**
 * Klasa Math dla zmiennych float
 */
public class Mathf {

    /**
     * Pole random dla użytku w klasie
     */
    private static Random rand = new Random();

    /**
     * Liczba PI
     */
    public static final float PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428f;

    public static final float EPSILON = (float) 1.0e-10;

    /**
     * Konstruktor
     */
    public Mathf() {}

    /* TODO TO THINK
    public static float inv_sqrt(float x) {
        long i;
        float x2, y;
        final float threehalfs = 1.5f
    }
    */

    /**
     * Klasa do liczenia wartości absolutnej liczby
     * @param x liczba
     * @return wartość absolutna podanej liczby
     */
    public static float abs(float x) {
        if (x < 0) x *= -1.0f;
        return x;
    }

    /**
     * Funkcja zamieniająca stopnie na radiany
     * @param x wartość kąta w stopniach
     * @return wartość kąta w radianach
     */
    public static float toRadians(float x) {
        return x * (PI / 180);
    }

    /**
     * Funkcja zamieniająca radiany na stopnie
     * @param x wartość kąta w radianach
     * @return wartość kąta w stopniach
     */
    public static float toDegrees(float x) {
        return x * (180 / PI);
    }
}
