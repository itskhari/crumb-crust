package models;

public class Drink  extends Food {
    String size, flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;

        switch(size.toLowerCase()) {
            case "small": price = 1.50; break;
            case "medium": price = 2.00; break;
            case "large": price = 2.50; break;
            default: price = 0;
        }
    }

    public String toString() {
        return size + " " + flavor + " - $" + String.format("%.2f", price);
    }
}

