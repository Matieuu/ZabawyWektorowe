package main;

public class Vector2 {
    private float x, y;
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }

    /**
     *
     * Returns sum of squared x and y (faster than magnitude)
     */
    public float sqaredMagnitude() {
        return (float)Math.pow(x, 2) + (float)Math.pow(y, 2);
        //return 0.0f; //TODO
    }
    public float magnitude() {
        return sqaredMagnitude();
    }
}
