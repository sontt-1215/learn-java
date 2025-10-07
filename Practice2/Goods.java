public abstract class Goods {
    protected String code;
    protected String name;
    protected int quantity;
    protected double price;

    public Goods(String code, String name, int quantity, double price) {
        this.code = code;
        this.name = name;
        this.quantity = quantity >= 0 ? quantity : 0;
        this.price = price;
    }

    public abstract double getVAT();

    public abstract String evaluate();

    @Override
    public String toString() {
        return "Code: " + code + ", Name: " + name + ", Quantity: " + quantity + ", Price: " + price;
    }

    public String getCode() {
        return code;
    }
}
