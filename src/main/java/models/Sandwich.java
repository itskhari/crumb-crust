package models;

import pricing.Pricing;
import java.util.ArrayList;

public class Sandwich extends Food {
    private int size;
    private String breadType;
    private boolean toasted;
    private ArrayList<Topping> toppings;

    public Sandwich(int size, String breadType, boolean toasted) {
        this.size = size;
        this.breadType = breadType;
        this.toasted = toasted;
        this.toppings = new ArrayList<Topping>();
        this.price = Pricing.getBasePrice(size);
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);

        if (topping.isMeat()) {
            price += Pricing.getMeatPrice(size);
            if (topping.isExtra()) price += Pricing.getExtraMeatPrice(size);
        }
        else if (topping.isCheese()) {
            price += Pricing.getCheesePrice(size);
            if (topping.isExtra()) price += Pricing.getExtraCheesePrice(size);
        }
    }
    public ArrayList<Topping> getToppings() {
        return toppings;
    }
    public String toString() {
        String result = size + "\" " + breadType;
        if (toasted) result += " (toasted)";
        result += "\nToppings:\n";

        for (Topping t : toppings) {
            result += "  - " + t.toString() + "\n";
        }

        result += String.format("Price: $%.2f", price);
        return result;
    }
}

