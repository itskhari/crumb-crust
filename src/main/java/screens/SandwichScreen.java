package screens;

import borders.UI;
import models.Order;
import models.Sandwich;
import models.Topping;
import java.util.Scanner;



public class SandwichScreen {

    private Scanner sc;
    private Order order;

    public SandwichScreen(Scanner sc, Order order) {
        this.sc = sc;
        this.order = order;
    }

    public void show() {

        UI.header("🥪 BUILD A SANDWICH");

        String bread = chooseBread();
        if (bread == null) return;

        int size = chooseSize();
        boolean toasted = chooseToasted();

        Sandwich sandwich = new Sandwich(size, bread, toasted);

        addMeats(sandwich);
        addCheeses(sandwich);
        addVeggies(sandwich);
        addSauces(sandwich);

        order.addItem(sandwich);
        UI.success("\n🥪 Sandwich added to order!\n");
    }

    // bread section
    private String chooseBread() {

        while (true) {
            UI.sub("Life is like a sandwich, bread comes first. Choose yours:");

            UI.option(1, "White", "🍞");
            UI.option(2, "Wheat", "🌾");
            UI.option(3, "Rye", "🍞");
            UI.option(4, "Wrap", "🌯");
            UI.option(0, "Return to Order Menu", "↩️");

            UI.prompt("Enter your choice: ");
            String choice = sc.nextLine();

             switch (choice) {
                case "1": return "White";
                case "2": return "Wheat";
                case "3": return "Rye";
                case "4": return "Wrap";
                case "0": return null;
                default: {
                    UI.warn("invalid selection, please try again.");
                }
            }
        }
    }

    // size
    private int chooseSize() {

        while (true) {
            UI.sub("Choose Sandwich Size:");

            UI.option(1, "4 inch", "📏");
            UI.option(2, "8 inch", "📏");
            UI.option(3, "12 inch", "📏");

            UI.prompt("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": return 4;
                case "2": return 8;
                case "3": return 12;
                default: {
                    UI.warn("invalid selection, please try again.");
                }
            }
        }
    }

    // toasted or not
    private boolean chooseToasted() {
        UI.prompt("Would you like it toasted? (Y/N): ");
        return sc.nextLine().equalsIgnoreCase("Y");
    }

    // meats
    private void addMeats(Sandwich sandwich) {

        boolean adding = true;

        while (adding) {

            UI.sub("Choose Your Protein:");

            UI.option(1, "Steak", "🥩");
            UI.option(2, "Ham", "🐖");
            UI.option(3, "Salami", "🍖");
            UI.option(4, "Roast Beef", "🥩");
            UI.option(5, "Chicken", "🍗");
            UI.option(6, "Bacon", "🥓");


            UI.prompt("Enter choice: ");
            String choice = sc.nextLine();


            String meatName = switch (choice) {
                case "1" -> "Steak";
                case "2" -> "Ham";
                case "3" -> "Salami";
                case "4" -> "Roast Beef";
                case "5" -> "Chicken";
                case "6" -> "Bacon";
                default -> "";
            };

            if (meatName.isEmpty()) {
                UI.warn("invalid selection, please try again");
                continue;
            }

            UI.prompt("Extra " + meatName + "? (Y/N): ");
            boolean extra = sc.nextLine().equalsIgnoreCase("Y");

            sandwich.addTopping(new Topping(meatName, "meat", extra));

            UI.success(meatName + " added!");

            // Ask to continue
            UI.option(1, "Add another meat", "➕");
            UI.option(2, "Continue", "➡️");
            UI.prompt("Enter choice: ");

            if (sc.nextLine().equals("2")) adding = false;
        }
    }

    // cheese
    private void addCheeses(Sandwich sandwich) {

        boolean adding = true;

        while (adding) {

            UI.sub("Choose Your Cheese:");

            UI.option(1, "American", "🧀");
            UI.option(2, "Provolone", "🧀");
            UI.option(3, "Cheddar", "🧀");
            UI.option(4, "Swiss", "🧀");


            UI.prompt("Enter choice: ");
            String choice = sc.nextLine();


            String cheeseName = switch (choice) {
                case "1" -> "American";
                case "2" -> "Provolone";
                case "3" -> "Cheddar";
                case "4" -> "Swiss";
                default -> "";
            };

            if (cheeseName.isEmpty()) {
                UI.warn("invalid selection, please try again.");
                continue;
            }

            UI.prompt("Extra " + cheeseName + "? (Y/N): ");
            boolean extra = sc.nextLine().equalsIgnoreCase("Y");

            sandwich.addTopping(new Topping(cheeseName, "cheese", extra));

            UI.success(cheeseName + " added!");

            UI.option(1, "Add another cheese", "➕");
            UI.option(2, "Continue", "➡️");
            UI.prompt("Enter choice: ");

            if (sc.nextLine().equals("2")) adding = false;
        }
    }

    // toppings
    private void addVeggies(Sandwich sandwich) {

        boolean adding = true;

        while (adding) {

            UI.sub("Choose Your Veggies:");

            UI.option(1, "Lettuce", "🥬");
            UI.option(2, "Peppers", "🫑");
            UI.option(3, "Onions", "🧅");
            UI.option(4, "Tomatoes", "🍅");
            UI.option(5, "Jalapenos", "🌶️");
            UI.option(6, "Cucumbers", "🥒");
            UI.option(7, "Pickles", "🥒");
            UI.option(8, "Guacamole", "🥑");
            UI.option(9, "Mushrooms", "🍄");


            UI.prompt("Enter choice: ");
            String choice = sc.nextLine();



            String toppingName = switch (choice) {
                case "1" -> "Lettuce";
                case "2" -> "Peppers";
                case "3" -> "Onions";
                case "4" -> "Tomatoes";
                case "5" -> "Jalapenos";
                case "6" -> "Cucumbers";
                case "7" -> "Pickles";
                case "8" -> "Guacamole";
                case "9" -> "Mushrooms";
                default -> "";
            };

            if (toppingName.isEmpty()) {
                UI.warn("invalid selection, please try again.");
                continue;
            }

            sandwich.addTopping(new Topping(toppingName, "other", false));

            UI.success(toppingName + " added!");

            UI.option(1, "Add another topping", "➕");
            UI.option(2, "Continue", "➡️");
            UI.prompt("Enter choice: ");

            if (sc.nextLine().equals("2")) adding = false;
        }
    }

   // sauces
    private void addSauces(Sandwich sandwich) {

        boolean adding = true;

        while (adding) {

            UI.sub("Choose Your Sauces:");

            UI.option(1, "Mayo", "🥪");
            UI.option(2, "Mustard", "🌭");
            UI.option(3, "Ketchup", "🍅");
            UI.option(4, "Ranch", "🥛");
            UI.option(5, "Thousand Islands", "🏝️");
            UI.option(6, "Vinaigrette", "🥗");


            UI.prompt("Enter choice: ");
            String choice = sc.nextLine();


            String sauceName = switch (choice) {
                case "1" -> "Mayo";
                case "2" -> "Mustard";
                case "3" -> "Ketchup";
                case "4" -> "Ranch";
                case "5" -> "Thousand Islands";
                case "6" -> "Vinaigrette";
                default -> "";
            };

            if (sauceName.isEmpty()) {
                UI.warn("invalid selection, please try again");
                continue;
            }

            sandwich.addTopping(new Topping(sauceName, "sauce", false));

            UI.success(sauceName + " added!");

            UI.option(1, "Add another sauce", "➕");
            UI.option(2, "Continue", "➡️");
            UI.prompt("Enter choice: ");

            if (sc.nextLine().equals("2")) adding = false;
        }
    }
}
