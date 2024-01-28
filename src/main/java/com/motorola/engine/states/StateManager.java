package com.motorola.engine.states;

import com.motorola.engine.Game;
import com.motorola.gameExample.ExampleState;
import com.motorola.menu.MenuState;
import com.motorola.test2D.Test2DState;
import com.motorola.test3D.Test3DState;

import java.awt.*;
import java.util.Stack;

public class StateManager {

    private Game game;

    Stack<State> states;

    public StateManager(Game game) {
        this.game = game;
        states = new Stack<>();
        //states.push(new ExampleState(game));
        //states.push(new Test2DState(game));
        //states.push(new MenuState(game));
        states.push(new Test3DState(game));
    }

    /**
     * adding another state
     * @param state
     */
    public void push(State state) {
        states.push(state);
    }

    /**
     * removing state from top
     * @return removed state
     */
    public State pop() {
        return states.pop();
    }

    /**
     * getting state to top
     * @return state from top
     */
    public State peek() {
        return states.peek();
    }

    public void set(State state) {
//        System.out.println(states.pop().getClass().getName() +" disposed");
        states.clear();
        states.push(state);
        System.out.println("State changed: " + peek());
    }

    public void update(double delta) {
        states.peek().stateUpdate(delta);
    }

    public void render(Graphics g) {
        states.peek().render(g);
    }
}
