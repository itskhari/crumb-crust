package models;

import java.util.ArrayList;

public class Order {
    private ArrayList<Item> items;

    public Order() {
        items = new ArrayList<Item>();
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0.0;
        for (Item i : items) total += i.getPrice();
        return total;
    }

    public String toString() {
        String result = "ORDER SUMMARY\n-------------------\n";

        for (int i = items.size() - 1; i >= 0; i--) {
            result += items.get(i).toString() + "\n\n";
        }

        result += String.format("TOTAL: $%.2f", getTotal());
        return result;
    }
}

