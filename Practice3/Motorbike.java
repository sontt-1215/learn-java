public class Motorbike extends Vehicle {
    private double capacity;

    public Motorbike(String vehicleNumber, String manufacturer, int year, String color,
                     Owner owner, double capacity) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.capacity = capacity;
    }

    @Override
    public String getType() {
        return "Motorbike";
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacity: " + capacity + "cc";
    }
}
