package productsClass;

import java.time.LocalDate;

public class productFactory {
    public static Product createProduct(String type) {
        switch(type) {
            case "Cheese":
                return new Cheese("Cheddar", 5.3, 500,500.0, LocalDate.of(2025, 7, 12));
            case "TV":
                return new TV("Samsung 55inch", 1000, 55,1500);
            case "Biscuit":
                return new Biscuit("Chocolate", 3.5, 55,200, LocalDate.of(2025, 12, 5));
            case "GameCodeScratchCard:DMC":
                return new GameCodeScratchCard("DMC", 20, 4);
            default:
                throw new IllegalArgumentException("Unknown product type");
        }
    }
}

