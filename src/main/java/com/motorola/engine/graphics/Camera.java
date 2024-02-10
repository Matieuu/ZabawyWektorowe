package com.motorola.engine.graphics;

import com.motorola.engine.*;

/**
 * Komponent
 */
    public class Camera {
    private double focalLength;
    private GameObject gameObject;
    private double fieldOfView;
    public double getFocalLength() {
        return focalLength;
    }

    public Camera(GameObject gameObject, double focalLength) {
        this.gameObject = gameObject;
        this.focalLength = focalLength;
        this.fieldOfView = Math.PI/2;//90 degree
    }
    public Camera(GameObject gameObject, double fieldOfView, double focalLength) {
        this.gameObject = gameObject;
        this.focalLength = focalLength;
        this.fieldOfView = fieldOfView;

        System.out.print(
                "\nCreated camera for"+ gameObject +" with:" +
                "\nfocal length == " + getFocalLength() + "("+focalLength+")" +
                "\nfield of view == " + getVerticalFieldOfView() + "("+fieldOfView+")" +
                "\nprojection multiplier == " + getProjectionMultiplier() + "\n");
    }

    public double getProjectionMultiplier() {
        return Math.tan(0.5*fieldOfView)
                / focalLength
                * gameObject.getGame().getWindowDimension().getWidth() * 0.5;
    }

    public void setFocalLength(double focalLength) {
        this.focalLength = focalLength;
    }
    public double getVerticalFieldOfView() {
        return fieldOfView;
    }
    public void setVerticalFieldOfView(double angle) {
        fieldOfView = angle;
        focalLength = (gameObject.getGame().getWindowDimension().getWidth())/(2*Math.tan(angle*0.5));
    }

    public GameObject getGameObject() {
        return gameObject;
    }
}
