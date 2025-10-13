import java.util.*;

public class VehicleManager {
    private List<Vehicle> vehicles = new ArrayList<>();

    public boolean addVehicle(Vehicle v) {
        for (Vehicle vehicle : vehicles) {
            if (vehicle.getVehicleNumber().equals(v.getVehicleNumber())) {
                System.out.println("❌ Duplicate vehicle number!");
                return false;
            }
        }
        vehicles.add(v);
        System.out.println("✅ Added successfully!");
        return true;
    }

    public Vehicle findByNumber(String number) {
        for (Vehicle v : vehicles) {
            if (v.getVehicleNumber().equals(number)) {
                return v;
            }
        }
        return null;
    }

    public List<Vehicle> findByOwner(String cmnd) {
        List<Vehicle> result = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.getOwner().getCmnd().equals(cmnd)) {
                result.add(v);
            }
        }
        return result;
    }

    public void deleteByManufacturer(String manufacturer) {
        vehicles.removeIf(v -> v.getManufacturer().equalsIgnoreCase(manufacturer));
    }

    public String manufacturerWithMostVehicles() {
        Map<String, Long> count = new HashMap<>();
        for (Vehicle v : vehicles) {
            count.put(v.getManufacturer(), count.getOrDefault(v.getManufacturer(), 0L) + 1);
        }
        return count.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("No data");
    }

    public void sortByManufacturerCount() {
        Map<String, Long> count = new HashMap<>();
        for (Vehicle v : vehicles) {
            count.put(v.getManufacturer(), count.getOrDefault(v.getManufacturer(), 0L) + 1);
        }
        vehicles.sort((a, b) -> Long.compare(
                count.getOrDefault(b.getManufacturer(), 0L),
                count.getOrDefault(a.getManufacturer(), 0L)
        ));
    }

    public void statistics() {
        Map<String, Long> stat = new HashMap<>();
        for (Vehicle v : vehicles) {
            stat.put(v.getType(), stat.getOrDefault(v.getType(), 0L) + 1);
        }
        System.out.println("\n--- Vehicle Type Statistics ---");
        for (var e : stat.entrySet()) {
            System.out.println(e.getKey() + ": " + e.getValue());
        }
    }

    public void displayAll() {
        vehicles.forEach(System.out::println);
    }
}
