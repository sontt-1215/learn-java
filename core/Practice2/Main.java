import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();

        Goods food = new Food("F01", "Milk", 10, 15.5,
                LocalDate.of(2025, 9, 1), LocalDate.of(2025, 10, 10), "Vinamilk");

        Goods electronics = new Electronics("E01", "TV", 2, 500, 24, 1.2);
        Goods crockery = new Crockery("C01", "Cup", 60, 2.5, "Minh Long", LocalDate.of(2025, 9, 15));

        manager.addGoods(food);
        manager.addGoods(electronics);
        manager.addGoods(crockery);

        System.out.println("\n=== INVENTORY LIST ===");
        manager.displayAll();
    }
}
