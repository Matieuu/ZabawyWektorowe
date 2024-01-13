package com.motorola.GameExample;

import java.awt.*;
import com.motorola.Line2D;
import com.motorola.Vector2;
import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;


public class ExampleSystem extends GameSystem {

    public ExampleSystem(Game mygame){
        super(mygame);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {
        gameObject.addValue("position", new Vector2(10,5));
    }
    @Override
    public void update(){
        for(GameObject obiect :usedObjects){
            Vector2 position = (Vector2) obiect.getValue("position");
            Vector2 position2 = new Vector2(position.getX()+10,position.getX()+10);
            position.x += 1;
            position.y += 2;
            mygame.drawLine2D(new Line2D(position,position2, Color.BLACK));
        }
    }
}
