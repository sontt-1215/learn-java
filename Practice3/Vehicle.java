import java.time.Year;

public abstract class Vehicle {
    protected String vehicleNumber;
    protected String manufacturer;
    protected int year;
    protected String color;
    protected Owner owner;

    public Vehicle(String vehicleNumber, String manufacturer, int year, String color, Owner owner) {
        if (!vehicleNumber.matches("\\w{5}")) {
            throw new IllegalArgumentException("Vehicle number must have exactly 5 characters");
        }
        if (!(manufacturer.equals("Honda") || manufacturer.equals("Yamaha") || manufacturer.equals("Toyota") || manufacturer.equals("Suzuki"))) {
            throw new IllegalArgumentException("Manufacturer must be Honda, Yamaha, Toyota, or Suzuki");
        }
        int currentYear = Year.now().getValue();
        if (year > currentYear || year < 2000) {
            throw new IllegalArgumentException("Year must be between 2000 and current year");
        }
        this.vehicleNumber = vehicleNumber;
        this.manufacturer = manufacturer;
        this.year = year;
        this.color = color;
        this.owner = owner;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public Owner getOwner() {
        return owner;
    }

    public abstract String getType();

    @Override
    public String toString() {
        return getType() + " | No: " + vehicleNumber + ", Maker: " + manufacturer + ", Year: " + year +
               ", Color: " + color + ", Owner: " + owner;
    }
}
