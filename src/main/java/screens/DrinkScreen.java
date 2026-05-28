package screens;

import models.Drink;
import models.Order;
import java.util.Scanner;

public class DrinkScreen {
    private Scanner sc;
    private Order order;

    public DrinkScreen(Scanner sc, Order order) {
        this.sc = sc;
        this.order = order;
    }

    public void show () {
        System.out.println("Quench your thirst");
        System.out.println("Start by choosing your drink size:");
        System.out.println("\t1. Small");
        System.out.println("\t2. Medium");
        System.out.println("\t3. Large");
        System.out.print("Enter your choice here: ");
        String sizeChoice = sc.nextLine();

        String size = "";
        switch (sizeChoice) {
            case "1":
                size = "Small";
                break;
            case "2":
                size = "Medium";
                break;
            case "3":
                size = "Large";
                break;
            default:
                System.out.println("invalid selection, please try again");
        }

        System.out.println("What beverage would you like?:");
        System.out.println("\t1. Coke");
        System.out.println("\t2. Sprite ");
        System.out.println("\t3. Root Beer");
        System.out.println("\t4. Lemonade");
        System.out.println("\t5. Sweet Tea");
        System.out.println("\t6. Unsweet Tea");
        System.out.println("\t7. Water");
        System.out.print("Enter your choice here: ");
        String flavorChoice = sc.nextLine();

        String flavor = "";

        switch (flavorChoice) {
            case "1":
                flavor = "Coke";
                break;
            case "2":
                flavor = "Sprite";
                break;
            case "3":
                flavor = "Root Beer";
            case "4":
                flavor = "Lemonade";
                break;
            case "5":
                flavor = "Sweet Tea";
                break;
            case "6":
                flavor = "Unsweet Tea";
                break;
            case "7":
                flavor = "Water";
                break;
            default:
                System.out.println("invalid selection, please try again");
        }

        Drink drink = new Drink(size, flavor);
        order.addItem(drink);

        System.out.println("Beverage added to order!");
    }
}
