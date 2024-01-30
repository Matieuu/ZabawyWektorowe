package com.motorola.engine;
import com.motorola.engine.default_systems.KeyboardEventListener;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    private Game game;

    public GamePanel(Game game) {
        this.game = game;
        setPreferredSize(new Dimension(1600, 900));
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