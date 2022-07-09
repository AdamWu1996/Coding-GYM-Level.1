public class Circle {
    private final float radius;

    public Circle(float radius) {
        this.radius = radius;
    }

    public float getRadius() {
        return this.radius;
    }

    public float getArea() {
        return (float) (Math.pow(getRadius(), 2) * Math.PI);
    }
}
