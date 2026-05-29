package screens;

import borders.UI;
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

                    UI.header("🏠 THE BREAD BANK");

                    System.out.println("Welcome to the Bread Bank! We Sell Bread, We Sell Loafs!\n");
                    System.out.println("What can we get started for you today?\n");

                    UI.option(1, "Start New Order", "🛒");
                    UI.option(2, "Exit", "🚪");

                    UI.prompt("Enter your choice: ");
                    String choice = sc.nextLine();

                    switch (choice) {
                        case "1":
                            Order order = new Order();
                            OrderScreen orderScreen = new OrderScreen(sc, order);
                            orderScreen.show();
                            break;

                        case "2":
                            UI.success("\nThank you for dining at The Bread Bank! 🥖");
                            run = false;
                            break;

                        default:
                            UI.warn("\nInvalid selection, please try again.\n");
                    }
                }
            }
        }
