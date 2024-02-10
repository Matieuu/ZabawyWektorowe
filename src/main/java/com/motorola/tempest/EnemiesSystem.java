package com.motorola.tempest;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.graphics.Model;

import java.awt.*;

public abstract class EnemiesSystem extends GameSystem {

    public int EnemiesDificulty;
    public int EnemiesLevel;

//    private Model enemyFliperModel;
//    private Model enemyTankerModel;
//    private Model enemySpikerModel;
//    private Model enemyFuseBallModel;

    EnemiesSystem(Game game, int enemiesDificulty) {
        super(game);
        this.EnemiesDificulty = enemiesDificulty;
        EnemiesLevel = 1;
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) {

    }

    @Override
    public void update(double delta) {

    }

    @Override
    public void render(Graphics g) {

    }
}
