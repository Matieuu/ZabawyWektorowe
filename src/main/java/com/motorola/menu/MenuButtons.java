package com.motorola.menu;

import com.motorola.engine.Game;
import com.motorola.engine.GameObject;
import com.motorola.engine.GameSystem;
import com.motorola.engine.default_systems.Renderer2D;
import com.motorola.engine.graphics.*;

import java.awt.*;
import java.util.ArrayList;

public class MenuButtons extends GameSystem {

    private Renderer2D renderer;

    private ArrayList<GameObject> buttons;

    private GameObject asteroids;
    private GameObject tempest;
    private GameObject battlezone;

    private int active;
    private double shift;
    private ArrayList<Vector2> points;
    private ArrayList<Line> edges;

    /**
     * Konstructor for Gamesystem
     *
     * @param game
     */
    public MenuButtons(Game game, Renderer2D renderer) {
        super(game);

        active = 0;
        shift = game.getWindowDimension().height / 4.0;
        buttons = new ArrayList<>();

        asteroids = new GameObject(game, "AsteroidButton");
        tempest = new GameObject(game, "TempestButton");
        battlezone = new GameObject(game, "BattlezoneButton");

        points = new ArrayList<>() {{
            add(new Vector2(-450, 75));
            add(new Vector2(450, 75));
            add(new Vector2(450, -75));
            add(new Vector2(-450, -75));
        }};

        edges = new ArrayList<>() {{
            add(new Line(0, 1, Color.WHITE));
            add(new Line(1, 2, Color.WHITE));
            add(new Line(2, 3, Color.WHITE));
            add(new Line(3, 0, Color.WHITE));
        }};

        asteroids.setValue("Model2D", new Model2D(points, edges, 1));
        asteroids.setValue("Transform", new Transform(new Vector3(0, -shift, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));
        asteroids.setValue("GameState", "asteroids");

        tempest.setValue("Model2D", new Model2D(points, edges, 1));
        tempest.setValue("Transform", new Transform(new Vector3(0, 0, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));
        tempest.setValue("GameState", "tempest");

        battlezone.setValue("Model2D", new Model2D(points, edges, 1));
        battlezone.setValue("Transform", new Transform(new Vector3(0, shift, 0), Quaternion.createEulerAngles(new Vector3(0, 0, 0))));
        battlezone.setValue("GameState", "battlezone");

        asteroids.setValue("content", "asteroids");
        tempest.setValue("content", "tempest");
        battlezone.setValue("content", "battle zone");

        renderer.addObject(asteroids);
        renderer.addObject(tempest);
        renderer.addObject(battlezone);

        buttons.add(asteroids);
        buttons.add(tempest);
        buttons.add(battlezone);
    }

    @Override
    public void addToGameObjectValues(GameObject gameObject) { }

    @Override
    public void update(double delta) { }

    @Override
    public void render(Graphics g) {
        double minX = Math.min(Math.min(points.get(0).getX(), points.get(1).getX()),
                Math.min(points.get(2).getX(), points.get(3).getX()));
        double maxX = Math.max(Math.max(points.get(0).getX(), points.get(1).getX()),
                Math.max(points.get(2).getX(), points.get(3).getX()));

        double minY = Math.min(Math.min(points.get(0).getY(), points.get(1).getY()),
                Math.min(points.get(2).getY(), points.get(3).getY()));
        double maxY = Math.max(Math.max(points.get(0).getY(), points.get(1).getY()),
                Math.max(points.get(2).getY(), points.get(3).getY()));

        for (GameObject btn : buttons) {
            Transform transform = (Transform) btn.getValue("Transform");
            String content = ((String) btn.getValue("content")).toUpperCase();
            int x = g.getFontMetrics().stringWidth(content) / 2;
            int y = g.getFont().getSize()/3;

            g.setFont(new Font("Default", Font.PLAIN, (int)  ((maxY - minY) * 2/3)));
            g.setColor(buttons.indexOf(btn) == active ? Color.WHITE : Color.DARK_GRAY);
            g.drawString(content, (int) (game.getWindowDimension().getWidth()/2 - x + transform.getPosition().getX()),
                    (int) (game.getWindowDimension().getHeight()/2 + y + transform.getPosition().getY()));
        }
    }

    public void increaseActive() {
        active++;
        if (active >= buttons.size())
            active = 0;
    }
    public void decreaseActive() {
        active--;
        if (active < 0)
            active = buttons.size() - 1;
    }

    public void changeState() {
        if (game.getStateManager().translateStateName((String) asteroids.getValue("GameState")) == null) return;
        game.getStateManager().push(game.getStateManager().translateStateName((String) asteroids.getValue("GameState")));
    }

    public int getActive() {
        return active;
    }
    public void setActive(int active) {
        this.active = active;
    }
    public ArrayList<GameObject> getButtons() {
        return buttons;
    }
}
