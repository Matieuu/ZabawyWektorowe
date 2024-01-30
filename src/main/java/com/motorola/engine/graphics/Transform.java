package com.motorola.engine.graphics;

public class Transform {
    private Vector3 position = Vector3.zero;
    private Quaternion rotation = Quaternion.createEulerAngles(Vector3.zero);
    public Transform() {

    }
    public Transform(Vector3 position, Quaternion rotation) {
        this.position = position;
        this.rotation = rotation;
    }
    public Quaternion getRotation() {
        return rotation;
    }
    public Vector3 getPosition() {
        return position;
    }
    public void setPosition(Vector3 position) {
        this.position = position;
    }
    public void setRotation(Quaternion rotation) {
        this.rotation = rotation;
    }
    public void rotate(double angle) {
        rotation = Quaternion.createEulerAngles(
                rotation.getEulerAnglesDegree().getX(),
                rotation.getEulerAnglesDegree().getY(),
                rotation.getEulerAnglesDegree().getZ() + angle
        );
    }

    @Override
    public String toString() {
        return "Transform (" + position + ", " + rotation + ")";
    }
}
