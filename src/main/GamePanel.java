package main;

import inputs.KeyboardInputs;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;

    // Konstruktor
    public GamePanel(Game game) {
        this.game = game;
        this.setPreferredSize(new Dimension(Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT));

        this.addKeyListener(new KeyboardInputs());
    }

    public void paintComponent(Graphics g) {
        g.fillRect(0, 0, Game.WINDOW_WIDTH, Game.WINDOW_HEIGHT);
    }

    public Game getGame() {
        return game;
    }
}
