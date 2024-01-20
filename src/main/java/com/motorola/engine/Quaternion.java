package com.motorola.engine;

public class Quaternion {
    private double w, x, y, z;
    public double getW() {
        return w;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
    public double getZ() {
        return z;
    }
    public Quaternion(double w, double x, double y, double z) {
        this.w = w;
        this.x = x;
        this.y = y;
        this.z = z;
    }
    public Quaternion() {
        this.w = 0f;
        this.x = 1f;
        this.y = 0f;
        this.z = 0f;
    }
    public double squaredMagnitude() {
        return w*w + x*x + y*y + z*z;
    }
    public Vector3 vector() {
        return new Vector3(x, y, z);
    }
    public double magnitude() {
        return Math.sqrt(squaredMagnitude());
    }
    public Quaternion normalized() {
        return this.multiply(1/Math.sqrt(squaredMagnitude()));
    }
    public Quaternion conjugate() {
        return new Quaternion(w, -x, -y, -z);
    }
    public Quaternion inverse() {
        double magnitude = magnitude();
        return new Quaternion(
            w / magnitude,
            -x / magnitude,
            -y / magnitude,
            -z / magnitude
        );
    }
    public static Quaternion createEulerAngles(double pitch, double yaw, double roll) {
        return createEulerAngles(new Vector3(pitch, yaw, roll));
    }

    public static Quaternion createEulerAngles(Vector3 angles) {
        double x = angles.getX()/2;
        double y = angles.getY()/2;
        double z = angles.getZ()/2;

        return new Quaternion(
                Math.cos(x)*Math.cos(y)*Math.cos(z)+Math.sin(x)*Math.sin(y)*Math.sin(z),
                Math.sin(x)*Math.cos(y)*Math.cos(z)-Math.cos(x)*Math.sin(y)*Math.sin(z),
                Math.cos(x)*Math.sin(y)*Math.cos(z)+Math.sin(x)*Math.cos(y)*Math.sin(z),
                Math.cos(x)*Math.cos(y)*Math.sin(z)-Math.sin(x)*Math.sin(y)*Math.cos(z)
        );
    }
    public Vector3 getEulerAnglesRadians() {
        double pitch = Math.asin(2*(w*y-x*z)); //pitch
        //double yaw = Math.atan2(2*(w*z+x*y), w*w+x*x-y*y-z*z); //yaw
        double yaw = Math.atan2(2*(w*z+x*y), (w*w+x*x-y*y-z*z)); //yaw
        //double roll = Math.atan2(2*(w*x+y*z), w*w-x*x-y*y+z*z); //roll
        double roll = Math.atan2(2*(w*x+y*z), (w*w-x*x-y*y+z*z)); //roll

        if (pitch == Math.PI/2) {
            roll = 0;
            yaw = -2*Math.atan2(x, w);
        } else if (pitch == -Math.PI/2) {
            roll = 0;
            yaw = 2*Math.atan2(x, w);
        }

        return new Vector3(pitch, yaw, roll);
    }
    public Vector3 getEulerAnglesDegree() {
        Vector3 inRadians = getEulerAnglesRadians();
        return new Vector3(
                inRadians.getX(),
                inRadians.getY(),
                inRadians.getZ()
        ).multiply(180.0/Math.PI);
    }
    public Quaternion add(Quaternion other) {
        return new Quaternion(w+other.getW(),x + other.getX(), y + other.getY(), z+other.getZ());
    }
    public Quaternion multiply(double multiplier) {
        return new Quaternion(w*multiplier,x*multiplier, y*multiplier, z*multiplier);
    }
    public Quaternion multiply(Quaternion other) {
        return new Quaternion(
                this.w*other.w - this.x*other.x - this.y*other.y - this.z*other.z,
                this.w*other.x + this.x*other.w + this.y*other.z - this.z*other.y,
                this.w*other.y - this.x*other.z + this.y*other.w + this.z*other.x,
                this.w*other.z + this.x*other.y - this.y*other.x + this.z*other.w
        );
    }
    public static Vector3 rotatePoint(Vector3 point, Quaternion rotation) {
        return rotation.multiply(
                new Quaternion(0, point.getX(), point.getY(), point.getZ())
        ).multiply(rotation.conjugate()).vector();
    }
    public static Vector2 rotatePoint(Vector2 point, Quaternion rotation) {
        Vector3 newPoint = rotation.multiply(
                new Quaternion(0, point.getX(), point.getY(), 0)
        ).multiply(rotation.conjugate()).vector();
        return new Vector2(newPoint.getX(), newPoint.getY());
    }
    @Override
    public String toString() {
        return "{" + w + ", " + x + ", " + y + ", " + z + '}';
    }
}
