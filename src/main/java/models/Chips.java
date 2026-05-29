package models;

public class Chips extends Food {
    private String type;

    public Chips(String type) {
        this.type = type;
        this.price = 1.25;
    }

    @Override
    public String toString() {
        return "🍟 Chips (" + type + ") - $" +
                String.format("%.2f", getPrice());
    }
}

