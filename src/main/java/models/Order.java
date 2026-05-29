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

        StringBuilder sb = new StringBuilder();

        sb.append("🧾 ORDER SUMMARY\n");
        sb.append("------------------------------------\n\n");

        for (Item item : items) {
            sb.append(item.toString()).append("\n");
        }

        sb.append("\n------------------------------------\n");
        sb.append(String.format("SUBTOTAL: $%.2f", getTotal()));
        sb.append("\n------------------------------------");

        return sb.toString();
    }
}

