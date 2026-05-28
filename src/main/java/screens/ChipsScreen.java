package screens;

import models.Chips;
import models.Order;
import java.util.Scanner;

public class ChipsScreen {
    private Scanner sc;
    private Order order;

    public ChipsScreen(Scanner sc, Order order) {
        this.sc = sc;
        this.order = order;
    }

    public void show () {

        System.out.println("Can't forget the sides");
        System.out.println("What kind of chips would you like?");
        System.out.println("\t1. BBQ");
        System.out.println("\t2. Sour Cream & Onion");
        System.out.println("\t3. Nacho Cheese");
        System.out.println("\t4. Salt & Vinegar");
        System.out.println("\t5. Classic");
        System.out.println("\t.0 No Chips");
        System.out.print("Enter your choice here: ");
        String chipChoice = sc.nextLine();

        String flavor = "";
        switch (chipChoice) {
            case "1":
                flavor = "BBQ";
                break;
            case "2":
                flavor = "Sour Cream & Onion";
                break;
            case "3":
                flavor = "Nacho Cheese";
                break;
            case "4":
                flavor = "Salt & Vinegar";
                break;
            case "5":
                flavor = "Classic";
                break;
            case "0":
                System.out.println("No Chips selected");
                return;
            default:
                System.out.println("invalid selection, please try again");
        }

        Chips chips = new Chips(flavor);
        order.addItem(chips);

        System.out.println("Chips added to order!");
    }
}
