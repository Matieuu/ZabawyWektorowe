package com.motorola.gameExample;

import java.awt.*;

import com.motorola.engine.graphics.Vector2;
import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;


public class ExampleSystem extends GameSystem {

    public ExampleSystem(Game mygame){
        super(mygame);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
        gameObject.setValue("position", new Vector2(10,5));
        gameObject.setValue("length", 10.0);
    }

    @Override
    public void update(double delta){
    }

    @Override
    public void render(Graphics g) {
        for(GameObject object : usedObjects){
            Vector2 position = (Vector2) object.getValue("position");
            double length = (double) object.getValue("length");
            object.setValue("length",length+=1);
            position.increase(new Vector2(1 + 1, 2 + 2));
            g.setColor(Color.WHITE);
            g.drawLine((int)position.getX(), (int)position.getY(), (int)(position.getX() + length), (int)(position.getY()+length));
        }
    }
}
