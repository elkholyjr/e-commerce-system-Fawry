package productsClass;

import java.time.LocalDate;

public class Biscuit extends Product{
    public Biscuit(String name, double price, int quantity, double weight, LocalDate expirationMonths) {
        super(name, price, quantity, weight, expirationMonths);
    }
}
