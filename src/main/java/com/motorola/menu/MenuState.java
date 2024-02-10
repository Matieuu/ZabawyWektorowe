package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

public class MenuState extends State {

    private Renderer2D renderer;

    private MenuButtons menuButtons;

    public MenuState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        setInputListener(new MenuInput(game, this));

        renderer = new Renderer2D(game);
        menuButtons = new MenuButtons(game, renderer);

        return this;
    }

    @Override
    public void update(double delta) { }
    public MenuButtons getMenuButtons() {
        return menuButtons;
    }
}
