public class Electronics extends Goods {
    private int warrantyMonths;
    private double powerKW;

    public Electronics(String code, String name, int quantity, double price, int warrantyMonths, double powerKW) {
        super(code, name, quantity, price);
        this.warrantyMonths = Math.max(0, warrantyMonths);
        this.powerKW = Math.max(0, powerKW);
    }

    @Override
    public double getVAT() {
        return 0.10;
    }

    @Override
    public String evaluate() {
        if (quantity < 3) return "Considered sold";
        return "No evaluation";
    }

    @Override
    public String toString() {
        return super.toString() + ", Warranty: " + warrantyMonths + " months, Power: " + powerKW + "KW";
    }
}
