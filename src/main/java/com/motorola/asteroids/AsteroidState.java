package com.motorola.asteroids;
import com.motorola.engine.*;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.states.State;

public class AsteroidState extends State {

    public AsteroidState(Game game) {
        super(game);
    }

    @Override
    public State load() {
        setInputListener(new AsteroidsInput(game));
        new GameObject(game,"Player");

        Renderer2D render = new Renderer2D(game);
        render.addObjectsByName("*Asteroid");
        render.addObjectsByName("Player");
        new AsteroidsSystem(game);

        return this;
    }

    @Override
    public void update(double delta) {
    }
}
