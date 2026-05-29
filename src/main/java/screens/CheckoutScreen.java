package screens;

import borders.UI;
import models.Order;
import receiptwriter.ReceiptWriter;

import java.util.Scanner;

public class CheckoutScreen {
    private Scanner sc;
    private Order order;

    public CheckoutScreen(Scanner sc, Order order) {
       this.sc = sc;
       this.order = order;
    }
    public boolean show() {
        UI.header("💳 CHECKOUT");


        UI.sub("Your Order:");
        System.out.println(order.toString());

        double subtotal = order.getTotal();
        double tax = subtotal * 0.07;
        double total = subtotal + tax;

        System.out.println(String.format("Tax: $%.2f", tax));
        System.out.println(String.format("TOTAL: $%.2f", total));
        UI.divider();

        while (true) {
            UI.option(1, "Confirm Order", "✅");
            UI.option(2, "Forgot Something? Return to Menu", "❌");
            UI.prompt("Enter your choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    UI.success("\n🎉 Order confirmed! Thank you for dining with us!\n");
                    ReceiptWriter.writeReceipt(order);
                    return true;
                case "2":
                    UI.warn("\nReturning to menu.\n");
                    return false;

                default:
                    UI.warn("invalid selection, please try again.\n");
                    }
                }
            }
        }

