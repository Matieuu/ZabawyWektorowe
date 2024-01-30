package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

public class MenuState extends State {

    private Renderer2D renderer;

    private ButtonsSystem btnSystem;

    public MenuState(Game game) {
        super(game);
        setInputListener(new MenuInputListener(game, this));

        renderer = new Renderer2D(game);
        btnSystem = new ButtonsSystem(game, renderer);
    }

    @Override
    public void update(double delta) { }
}
