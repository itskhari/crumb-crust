package models;

public class Topping {
    private String name;
    private String category;
    private boolean extra;

    public Topping(String name, String category, boolean extra) {
        this.name = name;
        this.category = category;
        this.extra = extra;
    }

    // getters
    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return extra;
    }

    public boolean isMeat() {
        return category.equalsIgnoreCase("meat");
    }
    public boolean isCheese() {
        return category.equalsIgnoreCase("cheese");
    }

    public String toString() {
        return name + (extra ? " (extra)" : "");
    }
}

