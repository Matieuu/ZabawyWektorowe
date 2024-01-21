package com.motorola.engine.states;

import com.motorola.engine.Game;
import com.motorola.gameExample.ExampleState;
import com.motorola.menu.MenuState;

import java.awt.*;
import java.util.Stack;

public class StateManager {

    private Game game;

    Stack<State> states;

    public StateManager(Game game) {
        this.game = game;
        states = new Stack<>();
        states.push(new ExampleState(game));
    }

    public void push(State state) {
        states.push(state);
    }

    public State pop() {
        return states.pop();
    }

    public State peek() {
        return states.peek();
    }

    public void set(State state) {
//        System.out.println(states.pop().getClass().getName() +" disposed");
        states.pop();
        states.push(state);
    }

    public void update(double delta) {
        states.peek().stateUpdate(delta);
    }

    public void render(Graphics g) {
        states.peek().render(g);
    }
}
