public class Square extends Rectangle {

    public Square(double side) {
        super(side, side);
    }

    @Override
    public void displayInfo() {
        System.out.println("Square:");
        System.out.println("Side: " + width);
        System.out.println("Area: " + getArea());
        System.out.println("Perimeter: " + getPerimeter());
        System.out.println();
    }
}
