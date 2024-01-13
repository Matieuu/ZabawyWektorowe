package com.motorola;

import com.motorola.GameExample.ExampleSystem;
import com.motorola.GameExample.Examplegame;
import com.motorola.engine.Game;

/**
 * Klasa główna
 */
public class MainClass {

    /**
     * Konstruktor
     */
    public MainClass() {}

    /**
     * Metoda główna
     * @param args Argumety, które obecnie nie są obsługiwane
     */
    public static void main(String[] args) {
        //Game game = new Game();

        Examplegame ep= new Examplegame();
        ep.MakeExampleGame();
    }
}
