public class Main {
    public static void main(String[] args) {
        Shape shape = new Shape(5, 10);
        shape.displayInfo();

        Rectangle rect = new Rectangle(4, 6);
        rect.displayInfo();

        Circle circle = new Circle(3);
        circle.displayInfo();

        Square square = new Square(5);
        square.displayInfo();
    }
}
