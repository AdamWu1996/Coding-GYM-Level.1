public class Triangle {
    private double button;
    private double height;

    public Triangle(double button, double height) {
        this.button = button;
        this.height = height;
    }

    public double getButton() {
        return button;
    }

    public double getHeight() {
        return height;
    }

    public double getArea(){
        return getButton() * getHeight() / 2;
    }
}
