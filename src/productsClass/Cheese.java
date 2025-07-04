package productsClass;

import java.time.LocalDate;

public class Cheese extends Product {
    public Cheese(String name, double price, int quantity, double weight, LocalDate expirationMonths) {
        super(name, price, quantity, weight, expirationMonths);
    }
}