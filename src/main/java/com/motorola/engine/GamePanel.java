package com.motorola.engine;
import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;

    // Konstruktor
    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(1000, 600));
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        game.paint(g);
    }

    public Game getGame() {
        return game;
    }
}