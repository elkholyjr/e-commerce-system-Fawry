package shippingService;

public class ShippableItemWrapper implements Shippable {
    private final String name;
    private final double weight;

    public ShippableItemWrapper(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getWeight() {
        return weight;
    }
}