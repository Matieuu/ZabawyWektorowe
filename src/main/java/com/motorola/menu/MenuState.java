package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.ButtonSystem;
import com.motorola.engine.default_systems.InputSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.List;

public class MenuState extends State {

    private Renderer2D renderer;

    private ButtonsSystem btnSystem;

    public MenuState(Game game) {
        super(game);

        renderer = new Renderer2D(game);
        btnSystem = new ButtonsSystem(game, renderer);
    }

    @Override
    public void update(double delta) {
    }
}
