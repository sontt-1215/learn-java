public class Truck extends Vehicle {
    private double tonnage;

    public Truck(String vehicleNumber, String manufacturer, int year, String color,
                 Owner owner, double tonnage) {
        super(vehicleNumber, manufacturer, year, color, owner);
        this.tonnage = tonnage;
    }

    @Override
    public String getType() {
        return "Truck";
    }

    @Override
    public String toString() {
        return super.toString() + ", Tonnage: " + tonnage + " tons";
    }
}
