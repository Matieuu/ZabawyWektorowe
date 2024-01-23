package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.default_systems.ButtonSystem;
import com.motorola.engine.states.State;

import java.util.ArrayList;
import java.util.List;

public class MenuState extends State {

    private List<ButtonSystem> buttons;

    public MenuState(Game game) {
        super(game);
        buttons = new ArrayList<>();
        // Menu logic to add
    }

    @Override
    public void update(double delta) {
    }
}
