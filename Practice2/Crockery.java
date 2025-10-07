import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Crockery extends Goods {
    private String manufacturer;
    private LocalDate dateOfArrival;

    public Crockery(String code, String name, int quantity, double price, String manufacturer, LocalDate dateOfArrival) {
        super(code, name, quantity, price);
        this.manufacturer = manufacturer;
        this.dateOfArrival = dateOfArrival;
    }

    @Override
    public double getVAT() {
        return 0.10;
    }

    @Override
    public String evaluate() {
        long daysStored = ChronoUnit.DAYS.between(dateOfArrival, LocalDate.now());
        if (quantity > 50 && daysStored > 10) {
            return "Slow sale";
        }
        return "No evaluation";
    }

    @Override
    public String toString() {
        return super.toString() + ", Manufacturer: " + manufacturer + ", Arrival: " + dateOfArrival;
    }
}
