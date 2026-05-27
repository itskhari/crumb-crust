package models;

public class Chips extends Food {
    private String type;

    public Chips(String type) {
        this.type = type;
        this.price = 1.25;
    }

    public String toString() {
        return type + " - $" + String.format("%.2f", price);
    }
}

