package models;

import java.util.*;

public class RandomOrder {

    private static Random random = new Random();

    public static Order generateRandomOrder() {

        Order order = new Order();

        // Random Sandwich
        order.addItem(generateRandomSandwich());

        // 50% chance to add a drink
        if (random.nextBoolean()) {
            order.addItem(generateRandomDrink());
        }

        // 50% chance to add chips
        if (random.nextBoolean()) {
            order.addItem(generateRandomChips());
        }

        return order;
    }

    private static Sandwich generateRandomSandwich() {

        Random random = new Random();

        String[] breads = {"White", "Wheat", "Wrap", "Rye"};
        int[] sizes = {4, 8, 12};
        boolean toasted = random.nextBoolean();

        Sandwich s = new Sandwich(
                sizes[random.nextInt(sizes.length)],
                breads[random.nextInt(breads.length)],
                toasted
            );

            // --- MEAT (always 1)
        String[] meats = {"Salami", "Ham", "Steak", "Chicken"};
        String meat = meats[random.nextInt(meats.length)];
        s.addTopping(new Topping(meat, "meat", random.nextBoolean()));

            // --- CHEESE (always 1)
        String[] cheeses = {"Provolone", "Cheddar", "Swiss", "American"};
        String cheese = cheeses[random.nextInt(cheeses.length)];
        s.addTopping(new Topping(cheese, "cheese", random.nextBoolean()));

            // --- VEGGIES (0–4 random)
        String[] veggies = {"Lettuce", "Tomato", "Onion", "Pickles", "Peppers", "Jalapenos"};
        int veggieCount = random.nextInt(5); // 0–4 veggies

        for (int i = 0; i < veggieCount; i++) {
            String veg = veggies[random.nextInt(veggies.length)];
            s.addTopping(new Topping(veg, "veggie", false));
        }

            // --- SAUCES (0–2 random)
        String[] sauces = {"Mayo", "Mustard", "Vinaigrette", "Ranch"};
        int sauceCount = random.nextInt(3); // 0–2 sauces

        for (int i = 0; i < sauceCount; i++) {
            String sauce = sauces[random.nextInt(sauces.length)];
            s.addTopping(new Topping(sauce, "sauce", false));
        }

        return s;
    }


    private static Drink generateRandomDrink() {

        String[] sizes = {"Small", "Medium", "Large"};
        String[] flavors = {"Coke", "Sprite", "Root Beer", "Lemonade"};

        return new Drink(
                sizes[random.nextInt(sizes.length)],
                flavors[random.nextInt(flavors.length)]
        );
    }

    private static Chips generateRandomChips() {

        String[] flavors = {"BBQ", "Sour Cream", "Original", "Salt & Vinegar"};

        return new Chips(flavors[random.nextInt(flavors.length)]);
    }
}

