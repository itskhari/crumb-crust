package screens;

import models.Order;

import java.util.Scanner;

public class OrderScreen {
    private Scanner sc;
    private Order order;

    public OrderScreen(Scanner sc, Order order) {
        this.sc = sc;
        this.order = order;
    }

    public void show () {
         boolean run = true;

         while (run) {
             System.out.println("Just a few clicks away from your neal!");
             System.out.println("\t1. Sandwiches");
             System.out.println("\t2. Beverages");
             System.out.println("\t3. Chips");
             System.out.println("\t4. Checkout");
             System.out.println("\t0. Return to Home Screen");
             System.out.print("Enter your choice here: ");
             String choice = sc.nextLine();

             switch (choice) {
                 case "1":
                     SandwichScreen sandwichScreen = new SandwichScreen(sc, order);
                     sandwichScreen.show();
                     break;
                 case "2":
                     DrinkScreen drinkScreen = new DrinkScreen(sc, order);
                     drinkScreen.show();
                     break;
                 case "3":
                     ChipsScreen chipsScreen = new ChipsScreen(sc, order);
                     chipsScreen.show();
                 case "4":
                     CheckoutScreen checkoutScreen = new CheckoutScreen(sc, order);
                     checkoutScreen.show();
                 case "0":
                     System.out.println("Canceling Order, Returning to Home Screen");
                     run = false;
                     break;
                 default:
                     System.out.println("invalid selection, please try again");
             }
         }
    }
}
