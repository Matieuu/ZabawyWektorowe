package com.motorola.engine;

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

    /**
     * Zwraca przybliżoną wartość odwrotności pierwiastka kwadratowego
     * @param number Liczba
     * @return 1/sqrt(x)
     */
    public static float inv_sqrt(float number) {
        float x2, y;
        final float threehalfs = 1.5f;

        x2 = number * 0.5f;
        y = number;
        long i = Float.floatToIntBits(y);
        i = 0x5f3759df - (i >> 1);
        y = Float.intBitsToFloat((int) i);
        y = y * (threehalfs - (x2 * y * y));

        return y;
    }


    /**
     * Potęgowanie z liczbą całkowitą dodatnią jako wykładnikiem
     * @param x podstawa
     * @param n wykładnik (liczba całkowita dodatnia)
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
     * Metoda do liczenia wartości absolutnej liczby
     * @param x liczba
     * @return wartość absolutna podanej liczby
     */
    public static float abs(float x) {
        if (x < 0) x *= -1.0f;
        return x;
    }

    /**
     * Zwraca silnię z x
     * @param x liczba
     * @return x!
     */
    public static float factorial(float x) {
        if (x <= 1) return 1;
        return x * factorial(x-1);
    }

    /**
     * Funkcja potęgująca w której wykładnik jest dodatnią liczbą całkowitą
     * @param base Podstawa
     * @param exponent Wykładnik
     * @return base^exponent
     */
    public static float power(float base, int exponent) {
        if (exponent == 0) return 1;
        return base * power(base, exponent-1);
    }

    /**
     * Funkcja cosinus korzystająca z szeregy taylora
     * @param angle Kąt w radianach
     * @return cosinus(angle)
     */
    public static float cos(float angle) {
        // te while są potrzebne żeby pętla for niżej nie musiała się iterować w nieskończoność
        /*
        while (angle > 2*PI) {
            angle -= 2*PI;
        }
        while (angle < -2*PI) {
            angle += 2*PI;
        }*/
        float sum = 0;
        for (int i = 0; i < 5; i++ ) { // tą dziesiątkę można zastąpić większą liczbą ale dycha powinna wystarczyć
            sum += power(angle, 2*i) * power(-1, i)/factorial(2*i);
        }
        return sum;
    }

    /**
     * Funkcja sinus
     * @param angle Kąt w radianach
     * @return sinus(angle)
     */
    public static float sin(float angle) {
        return cos(angle - PI/2);
    }
    public static float tan(float angle) {
        return sin(angle)/cos(angle);
    }
    public static float ctg(float angle) {
        return cos(angle)/sin(angle);
    }
    public static float asin(float x) {
        return (float)Math.asin(x); // TODO
    }
    public static float atan(float x) {
        return (float)Math.atan(x); // TODO
    }
    public static float atan2(float x, float y) {
        return (float)Math.atan2(x, y); // TODO
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
