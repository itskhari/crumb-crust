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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("🥪 Sandwich (")
                .append(size).append("\" ")
                .append(breadType);

        if (toasted) sb.append(", Toasted");

        sb.append(") - $")
                .append(String.format("%.2f", getPrice()))
                .append("\n");

        for (Topping t : toppings) {
            sb.append("   • ").append(t.getName());
            if (t.isExtra()) sb.append(" (extra)");
            sb.append("\n");
        }

        return sb.toString();
    }

}

