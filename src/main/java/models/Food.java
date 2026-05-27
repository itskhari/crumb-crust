package models;

public abstract class Food implements Item {
    protected double price;

    @Override
    public double getPrice() {
        return price;
    }
}
