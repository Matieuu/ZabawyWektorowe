package com.motorola.engine.states;

import com.motorola.asteroids.AsteroidState;
import com.motorola.engine.Game;
import com.motorola.gameExample.ExampleState;
import com.motorola.menu.MenuState;
import com.motorola.tempest.TempestState;
import com.motorola.test2D.Test2DState;
import com.motorola.test3D.Test3DState;

import java.awt.*;
import java.util.Stack;

public class StateManager {

    private Game game;

    Stack<State> states;

    private MenuState menuState;
    private AsteroidState asteroidState;
    private TempestState tempestState;

    // temporary states
    private Test2DState test2DState;
    private Test3DState test3DState;
    private ExampleState exampleState;

    public StateManager(Game game) {
        this.game = game;
        states = new Stack<>();

        menuState = new MenuState(game);
        asteroidState = new AsteroidState(game);
        tempestState = new TempestState(game);

        exampleState = new ExampleState(game);
        test2DState = new Test2DState(game);
        test3DState = new Test3DState(game);
    }

    /**
     * adding another state
     * @param state
     */
    public void push(State state) {
        if (peek() != null)
            peek().unload();
        states.push(state);
    }

    /**
     * removing state from top
     * @return removed state
     */
    public State pop() {
        State temp = states.pop().unload();
        peek().load();
        return temp;
    }

    /**
     * getting state from top
     * @return state from top
     */
    public State peek() {
        return states.isEmpty() ? null : states.peek();
    }

    public State set(State state) {
        pop();
        push(state);
        return peek();
    }

    public void update(double delta) {
        if (peek() == null) return;
        peek().stateUpdate(delta);
    }
    public void render(Graphics g) {
        if (peek() == null) return;
        peek().render(g);
    }

    public MenuState getMenuState() {
        return menuState;
    }
    public AsteroidState getAsteroidState() {
        return asteroidState;
    }
    public TempestState getTempestState() {
        return tempestState;
    }
    public Test2DState getTest2DState() {
        return test2DState;
    }
    public Test3DState getTest3DState() {
        return test3DState;
    }
    public ExampleState getExampleState() {
        return exampleState;
    }

    public State translateStateName(String state) {
        switch (state.toLowerCase()) {
            case "menustate":
            case "menu state":
            case "menu":
                return menuState;
            case "asteroidstate":
            case "asteroidsstate":
            case "asteroid state":
            case "asteroids state":
            case "asteroid":
            case "asteroids":
                return asteroidState;
            case "tempeststate":
            case "tempest state":
            case "tempest":
                return tempestState;
            case "examplestate":
            case "example state":
            case "example":
                return exampleState;
            case "test2dstate":
            case "test2d state":
            case "test 2dstate":
            case "test 2d state":
            case "test2d":
            case "test 2d":
                return test2DState;
            case "test3dstate":
            case "test3d state":
            case "test 3dstate":
            case "test 3d state":
            case "test3d":
            case "test 3d":
                return test3DState;
            default:
                return null;
        }
    }
}
