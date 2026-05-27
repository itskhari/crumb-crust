package screens;

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

        System.out.println("Life is like a sandwich, bread come first.");
        System.out.println("What type of bread would you like?");
        System.out.println("\t1. White");
        System.out.println("\t2. Wheat");
        System.out.println("\t3. Rye");
        System.out.println("\t4. Wrap");
        System.out.print("Enter you choice here: ");
        String breadChoice = sc.nextLine();
        String breadType = "";

        switch (breadChoice) {
            case "1":
                breadType = "White";
                break;
            case "2":
                breadType = "Wheat";
                break;
            case "3":
                breadType = "Rye";
                break;
            case "4":
                breadType = "Wrap";
                break;
            default:
                System.out.println("Your sandwich ain't got no bread! try again");

        }

        System.out.println("What size would you like your Sandwich?");
        System.out.println("\t.1 4\"");
        System.out.println("\t2. 8\"");
        System.out.println("\t3. 12\"");
        System.out.print("Select your size here: ");
        String sizeChoice = sc.nextLine();
        int size = 0;

        switch (sizeChoice) {
            case "1":
                size = 4;
                break;
            case "2":
                size = 8;
                break;
            case "3":
                size = 12;
                break;
            default:
                System.out.println("invalid selection, please try again");
        }

        Sandwich sandwich = new Sandwich(size, breadType, false);

        boolean addingMeats = true;

        while (addingMeats) {
            System.out.println("Choose Your Protein:");
            System.out.println("\t1. Steak");
            System.out.println("\t2. Ham");
            System.out.println("\t3. Salami");
            System.out.println("\t4. Roast Beef");
            System.out.println("\t5. Chicken");
            System.out.println("\t6. Bacon");
            System.out.println("\t0. Finished");
            System.out.print("Enter choice here: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                addingMeats = false;
                continue;
            }

            String meatName = "";
            switch (choice) {
                case "1":
                    meatName = "Steak";
                    break;
                case "2":
                    meatName = "Ham";
                    break;
                case "3":
                    meatName = "Salami";
                    break;
                case "4":
                    meatName = "Roast Beef";
                    break;
                case "5":
                    meatName = "Chicken";
                    break;
                case "6":
                    meatName = "Bacon";
                    break;
                default:
                    System.out.println("invalid selection, please try again");
                    continue;
            }

            System.out.println("Would you like extra " + meatName + "? (Y/N)");
            boolean extra = sc.nextLine().equalsIgnoreCase("Y");

            sandwich.addTopping(new Topping(meatName, "meat", extra));

        }

        boolean addingCheese = true;

        while (addingCheese) {
            System.out.println("What Cheese would you like?");
            System.out.println("\t1. American");
            System.out.println("\t2. Provolone");
            System.out.println("\t3. Cheddar");
            System.out.println("\t4. Swiss");
            System.out.println("\t0. Finished");
            System.out.print("Enter your choice here: ");
            String choice = sc.nextLine();

            if (choice.equals("0")) {
                addingCheese = false;
                continue;
            }
            String cheeseName = "";
            switch (choice) {
                case "1":
                    cheeseName = "American";
                    break;
                case "2":
                    cheeseName = "Provolone";
                    break;
                case "3":
                    cheeseName = "Cheddar";
                    break;
                case "4":
                    cheeseName = "Swiss";
                    break;
                default:
                    System.out.println("invalid selection, please try again");
                    continue;
            }
            System.out.print("Would you like extra " + cheeseName + "? (Y/N): ");
            boolean extra = sc.nextLine().equalsIgnoreCase("Y");

            sandwich.addTopping(new Topping(cheeseName, "cheese", extra));
        }
        boolean addingOther = true;

        while (addingOther) {
            System.out.println("Select your Toppings:");
            System.out.println("\t1. Lettuce");
            System.out.println("\t2. Peppers");
            System.out.println("\t3. Onions");
            System.out.println("\t4. Tomatoes");
            System.out.println("\t5. Jalapenos");
            System.out.println("\t6. Cucumbers");
            System.out.println("\t7. Pickles");
            System.out.println("\t8. Guacamole");
            System.out.println("\t9. Mushrooms");
            System.out.println("\t0. Done with regular toppings");
            System.out.print("Enter your choice(s) here: ");

            String choice = sc.nextLine();

            if (choice.equals("0")) {
                addingOther = false;
                continue;
            }
            String toppingName = "";
            switch (choice) {
                case "1":
                    toppingName = "Lettuce";
                    break;
                case "2":
                    toppingName = "Peppers";
                    break;
                case "3":
                    toppingName = "Onions";
                    break;
                case "4":
                    toppingName = "Tomatoes";
                    break;
                case "5":
                    toppingName = "Jalapenos";
                    break;
                case "6":
                    toppingName = "Cucumbers";
                    break;
                case "7":
                    toppingName = "Pickles";
                    break;
                case "8":
                    toppingName = "Guacamole";
                    break;
                case "9":
                    toppingName = "Mushrooms";
                    break;
                default:
                    System.out.println("invalid selection, please try again");
                    continue;
            }

            sandwich.addTopping(new Topping(toppingName, "other", false));
        }
        boolean addingSauces = true;
        while (addingSauces) {
            System.out.println("Last but not least Sauces:");
            System.out.println("\t1. Mayo");
            System.out.println("\t2. Mustard");
            System.out.println("\t.3 Ketchup");
            System.out.println("\t.4 Ranch");
            System.out.println("\t5. Thousand Islands");
            System.out.println("\t6. Vinaigrette");
            System.out.println("\t0. Done with sauces");
            System.out.print("Enter your choice(s) here: ");

            String choice = sc.nextLine();

            if (choice.equals("0")) {
                addingSauces = false;
                continue;
            }

            String sauceName = "";
            switch (choice) {
                case "1":
                    sauceName = "Mayo";
                    break;
                case "2":
                    sauceName = "Mustard";
                    break;
                case "3":
                    sauceName = "Ketchup";
                    break;
                case "4":
                    sauceName = "Ranch";
                    break;
                case "5":
                    sauceName = "Thousand Islands";
                    break;
                case "6":
                    sauceName = "Vinaigrette";
                    break;
                default:
                    System.out.println("invalid selection, please try again.");
                    continue;
            }

            sandwich.addTopping(new Topping(sauceName, "sauce", false));
        }
        System.out.print("Would you like it toasted? (Y/N): ");
        boolean toasted = sc.nextLine().equalsIgnoreCase("y");

        Sandwich finalSandwich = new Sandwich(size, breadType, toasted);
        for (Topping t : sandwich.getToppings()) {
            finalSandwich.addTopping(t);
        }
        order.addItem(finalSandwich);
        System.out.println("Sandwich added to order!");

    }
}
