package com.motorola.engine;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;

    // Konstruktor
    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(1600, 900));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (game.getStateManager() != null)
            game.render(g);
    }

    public Game getGame() {
        return game;
    }
}