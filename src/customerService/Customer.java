package customerService;

public class Customer {
    protected String name;
    private int balance;
    private Cart cart;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.cart = new Cart();
    }

    protected int getBalance() {
        return balance;
    }

    private void subtractBalance(int cost) {
        this.balance -= cost;
    }

    public Cart getCart() {
        return cart;
    }

    public void checkout() {
        if (this.cart.getCartSize() == 0) {
            throw new IllegalArgumentException("Empty Cart");
        }
        double total = this.cart.getTotalPrice();
        if (this.cart.getTotalWeights() != 0) {
            total += 30;
        }
        if (this.balance < total) {
            throw new IllegalArgumentException("Not enough Money");
        }
        this.subtractBalance((int) total);
        this.cart.printCart();
        System.out.println("Remaining balance: " + this.balance + "EGP");
    }

}
