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
    private static float accuracy = 0.000001f;

    /**
     * Liczba PI
     */
    public static final float PI = 3.141592653589793238462643383279502884197169399375105820974944592307816406286208998628034825342117067982148086513282306647093844609550582231725359408128481117450284102701938521105559644622948954930381964428f;

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
     * Potęgowanie
     * @param x podstawa
     * @param n wykładnik
     * @return wynik
     */
    public static float pow(float x, int n) {
        float result = 1;
        for (int i = 0; i < n; i++)
            result *= x;
        return result;
    }

    /**
     * Pierwiastkowanie
     * @param x podstawa
     * @param n wykładnik
     * @return wynik
     */
    public static float sqrt(float x, int n) {
        float xk = x / n;
        float xkPlusOne = (1.0f / n) * ((n - 1) * xk + x / (float) Math.pow(xk, n - 1));
        while (Math.abs(xkPlusOne - xk) >= accuracy) {
            xk = xkPlusOne;
            xkPlusOne = (1.0f / n) * ((n - 1) * xk + x / (float) Math.pow(xk, n - 1));
        }
        return xkPlusOne;
    }

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
