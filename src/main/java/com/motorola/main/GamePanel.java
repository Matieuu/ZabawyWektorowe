package com.motorola.main;

import com.motorola.inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

/**
 * Klasa Panelu, na którym wyświetlamy elementy gry
 */
public class GamePanel extends JPanel {

    /**
     * Instancja gry
     */
    private Game game;

    /**
     * Konstruktor Panelu
     * @param game Instancja gry
     */
    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(this.game.windowWidth, this.game.windowHeight));

        this.addKeyListener(new KeyboardInputs());
    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, game.windowWidth, game.windowHeight);
        game.render(g);
    }

    /**
     * Zwraca instancję gry
     * @return Instancja gry
     */
    public Game getGame() {
        return game;
    }
}
