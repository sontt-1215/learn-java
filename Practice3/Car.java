public class Car extends Vehicle {
    private int seats;
    private String engineType;

    public Car(String vehicleNumber, String manufacturer, int year, String color,
               Owner owner, int seats, String engineType) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.seats = seats;
        this.engineType = engineType;
    }

    @Override
    public String getType() {
        return "Car";
    }

    @Override
    public String toString() {
        return super.toString() + ", Seats: " + seats + ", Engine: " + engineType;
    }
}
