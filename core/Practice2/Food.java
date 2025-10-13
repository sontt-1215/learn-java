import java.time.LocalDate;

public class Food extends Goods {
    private LocalDate manufactureDate;
    private LocalDate expiryDate;
    private String supplier;

    public Food(String code, String name, int quantity, double price,
                LocalDate manufactureDate, LocalDate expiryDate, String supplier) {
        super(code, name, quantity, price);
        if (expiryDate.isBefore(manufactureDate)) {
            throw new IllegalArgumentException("Expiry date must be after manufacture date");
        }
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.supplier = supplier;
    }

    @Override
    public double getVAT() {
        return 0.05;
    }

    @Override
    public String evaluate() {
        if (quantity > 0 && expiryDate.isBefore(LocalDate.now())) {
            return "Hard to sell (expired)";
        }
        return "No evaluation";
    }

    @Override
    public String toString() {
        return super.toString() + ", Supplier: " + supplier + ", Mfg: " + manufactureDate + ", Exp: " + expiryDate;
    }
}
