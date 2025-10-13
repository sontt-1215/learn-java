public class Main {
    public static void main(String[] args) {
        VehicleManager manager = new VehicleManager();

        Owner o1 = new Owner("012345678901", "Nguyen Van A", "a@gmail.com");
        Owner o2 = new Owner("098765432109", "Tran Thi B", "b@yahoo.com");

        Vehicle v1 = new Car("A1234", "Toyota", 2023, "Red", o1, 5, "Hybrid");
        Vehicle v2 = new Motorbike("B5678", "Honda", 2024, "Black", o1, 125);
        Vehicle v3 = new Truck("C9999", "Suzuki", 2022, "White", o2, 8);
        Vehicle v4 = new Car("D0001", "Toyota", 2024, "Blue", o2, 7, "Diesel");

        manager.addVehicle(v1);
        manager.addVehicle(v2);
        manager.addVehicle(v3);
        manager.addVehicle(v4);

        System.out.println("\n--- All Vehicles ---");
        manager.displayAll();

        System.out.println("\nSearch by number B5678:");
        System.out.println(manager.findByNumber("B5678"));

        System.out.println("\nVehicles of CMND 012345678901:");
        manager.findByOwner("012345678901").forEach(System.out::println);

        System.out.println("\nManufacturer with most vehicles: " + manager.manufacturerWithMostVehicles());

        System.out.println("\nAfter sorting by manufacturer count desc:");
        manager.sortByManufacturerCount();
        manager.displayAll();

        manager.statistics();

        System.out.println("\nDelete all Toyota vehicles...");
        manager.deleteByManufacturer("Toyota");
        manager.displayAll();
    }
}
