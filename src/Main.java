import customerService.Cart;
import customerService.Customer;
import productsClass.Product;
import productsClass.productFactory;
import shippingService.Shippable;
import shippingService.ShippingService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Product cheese = productFactory.createProduct("Cheese");
        Product tv = productFactory.createProduct("TV");
        Product gameCard = productFactory.createProduct("GameCodeScratchCard:DMC");

        Customer customer = new Customer("Alice", 2000);
        Cart cart = customer.getCart();

        cart.add(cheese, 2);
        cart.add(tv, 1);
        cart.add(gameCard, 1);


        customer.checkout();
        System.out.println("------------------------");

        ShippingService shippingService = new ShippingService();
        List<Shippable> shippables = cart.getItemsForShipping();
        shippingService.ship(shippables);

    }
}