package screens;

import borders.UI;
import models.Order;
import models.RandomOrder;

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

            UI.header("🛒 ORDER MENU");

            UI.option(1, "Add Sandwich", "🥪");
            UI.option(2, "Add Drink", "🥤");
            UI.option(3, "Add Chips", "🍟");
            UI.option(4, "Checkout", "💳");
            UI.option(5, "Surprise Me", "🎲");
            UI.option(0, "Cancel Order", "❌");
            UI.prompt("Enter your choice: ");
            String choice = sc.nextLine();

                    switch (choice) {

                        case "1":
                            new SandwichScreen(sc, order).show();
                            break;

                        case "2":
                            new DrinkScreen(sc, order).show();
                            break;

                        case "3":
                            new ChipsScreen(sc, order).show();
                            break;

                        case "4":
                            boolean confirmed = new CheckoutScreen(sc, order).show();
                            if (confirmed) {
                                return;
                            }
                            break;

                        case "5":
                            Order randomOrder = RandomOrder.generateRandomOrder();
                            boolean confirm = new CheckoutScreen(sc, randomOrder).show();

                            if (confirm) {
                                return;
                            }
                            break;

                        case "0":
                            UI.warn("\nOrder canceled. Returning to Home.\n");
                            run = false;
                            break;

                        default:
                            UI.warn("\nInvalid selection, please try again.\n");
                    }
                }
            }
        }
