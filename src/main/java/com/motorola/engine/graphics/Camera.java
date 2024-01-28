package com.motorola.engine.graphics;

import com.motorola.engine.*;

/**
 * Komponent
 */
    public class Camera {
    private double focalLength;
    private GameObject gameObject;
    public double getFocalLength() {
        return focalLength;
    }

    public Camera(GameObject gameObject, double focalLength) {
        this.gameObject = gameObject;
        this.focalLength = focalLength;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }
    public double getFieldOfView() {
        return 2*Math.atan(1.0/focalLength);
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
