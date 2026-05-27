package screens;

import models.Order;

import java.util.Scanner;

public class HomeScreen {
    private Scanner sc;

    public HomeScreen(Scanner sc) {
        this.sc = sc;
    }

    public void show() {
        boolean run = true;

        while (run) {
            System.out.println("Welcome to the Bread Bank, We Sell Bread, We Sell Loafs");
            System.out.println("What can we get started for you today?");
            System.out.println("Select an option below:");
            System.out.println("\t1. Start New Order");
            System.out.println("\t2. Exit");
            System.out.print("Enter your choice here: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    Order order = new Order();
                    OrderScreen orderScreen = new OrderScreen(sc, order);
                    orderScreen.show();
                    break;
                case "2":
                    System.out.println("Thank you for dining at Crumbs and Crust!");
                    run = false;
                    break;
                default:
                    System.out.println("invalid selection, please try again");
            }
        }
    }
}
