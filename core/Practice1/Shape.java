public class Shape {
    protected double width;
    protected double height;

    public Shape() {}

    public Shape(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void displayInfo() {
        System.out.println("Shape: width = " + width + ", height = " + height);
    }
}
