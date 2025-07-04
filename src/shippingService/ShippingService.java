package shippingService;

import java.util.List;

public class ShippingService {
    public void ship(List<Shippable> items) {
        if (items == null || items.isEmpty()) {
            System.out.println("No items to ship.");
            return;
        }
        double totalWeight = 0;
        System.out.println("** Shipping Order **");
        for (Shippable item : items) {
            System.out.println("- " + item.getName() + ": " + item.getWeight() + "g");
            totalWeight += item.getWeight();
        }
        System.out.println("Total weight: " + (totalWeight / 1000) + "kg");
        System.out.println("Shipment is ready to be processed.");
    }

}
