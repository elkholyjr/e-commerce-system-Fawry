package productsClass;

import java.time.LocalDate;

public abstract class Product {
    protected String name;
    protected Double price, weight;
    protected LocalDate expirationDate;
    protected int quantity;

    public Product(String name, double price, int quantity) {
        this(name, price, quantity, null, null);
    }

    public Product(String name, double price, int quantity, double weight) {
        this(name, price, quantity, weight, null);
    }

    public Product(String name, double price, int quantity, LocalDate expirationDate) {
        this(name, price, quantity, null, expirationDate);
    }

    public Product(String name, double price, int quantity, Double weight, LocalDate expirationDate) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.weight = weight;
        this.expirationDate = expirationDate;
    }

    public double getPrice() {return price;}
    public String getName() {return name;}
    public int getQuantity() {return quantity;}
    public Double getWeight() {return weight;}
    public LocalDate getExpirationDate() {return expirationDate;}
    public void quantitySubtraction(int quantity) {
        this.quantity -= quantity;
    }
}
