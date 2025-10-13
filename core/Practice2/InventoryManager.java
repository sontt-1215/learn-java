import java.util.ArrayList;
import java.util.List;

public class InventoryManager {
    private List<Goods> goodsList = new ArrayList<>();

    public boolean addGoods(Goods g) {
        for (Goods existing : goodsList) {
            if (existing.getCode().equals(g.getCode())) {
                System.out.println("Duplicate product code!");
                return false;
            }
        }
        goodsList.add(g);
        System.out.println("Added successfully!");
        return true;
    }

    public void displayAll() {
        for (Goods g : goodsList) {
            System.out.println(g);
            System.out.println("VAT: " + (g.getVAT() * 100) + "%");
            System.out.println("Evaluation: " + g.evaluate());
            System.out.println("--------------------");
        }
    }
}
