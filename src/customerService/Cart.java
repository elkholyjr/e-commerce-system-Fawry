package customerService;

import productsClass.Product;
import shippingService.Shippable;
import shippingService.ShippableItemWrapper;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class Cart {

    private static class CartItem {
        Product product;
        int quantity;

        CartItem(Product product, int quantity) {
            this.product = product;
            this.quantity = quantity;
        }
    }

    private List<CartItem> items = new ArrayList<>();
    protected int size = 0;

    public List<Shippable> getItemsForShipping() {
        List<Shippable> shippables = new ArrayList<>();
        for (CartItem item : items) {
            Product product = item.product;
            if (product.getWeight() != null) {
                for (int i = 0; i < item.quantity; i++) {
                    shippables.add(new ShippableItemWrapper(product.getName(), product.getWeight()));
                }
            }
        }
        return shippables;
    }

    public void add(Product product, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be > 0" +product.getName());
        }
        if (product.getQuantity() - quantity < 0) {
            throw new IllegalArgumentException("Not enough stock " +product.getName());
        }
        if (product.getExpirationDate() != null && product.getExpirationDate().isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Product is expired" +product.getName());
        }
        product.quantitySubtraction(quantity);
        items.add(new CartItem(product, quantity));
        size++;
    }

    public double getTotalPrice() {
        double total = 0;
        for (CartItem item : items) {
            total += item.product.getPrice() * item.quantity;
        }
        return total;
    }

    public double getTotalWeights() {
        double weights = 0;
        for (CartItem item : items) {
            if (item.product.getWeight() == null)
                continue;
            weights += item.product.getWeight() * item.quantity;
        }
        return weights / 1000;
    }

    public int getCartSize() {
        return size;
    }

    public void printCart() {
        double totalPrice = getTotalPrice();
        double totalWeights = getTotalWeights();
        System.out.println("** Shipment notice **");
        for (CartItem item : items) {
            if(item.product.getWeight() == null) continue;
            System.out
                    .println(item.quantity + " x " + item.product.getName() + "     " + item.product.getWeight() + "g");
        }
        if (totalWeights != 0) {
            System.out.println("Total package weight   " + totalWeights + "KG");
        }
        System.out.println("** Checkout receipt **");
        for (CartItem item : items) {
            System.out.println(item.quantity + " x " + item.product.getName() + "     "
                    + item.product.getPrice() * item.quantity + "EGP");
        }
        System.out.println("----------------------");
        if (getTotalWeights() == 0) {
            System.out.println("Amount   " + totalPrice + "EGP");
            return;
        }

        System.out.println("Subtotal   " + totalPrice + "EGP");
        System.out.println("Shipping   " + 30 + "EGP");
        System.out.println("Amount   " + (totalPrice + 30 + "EGP"));
    }
}
