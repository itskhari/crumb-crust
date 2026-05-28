package screens;

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
    public void show() {
        System.out.println("Final steps of securing you meal!");
        System.out.println(order.toString());

        System.out.println("\t1. Confirm Order");
        System.out.println("\t0. Cancel");
        System.out.print("Enter your choice here: ");
        String choice = sc.nextLine();

        switch (choice) {
            case "1":
                ReceiptWriter.writeReceipt(order);
                System.out.println("Order Confirmed!");
                break;
            case "0":
                System.out.println("Order canceled, returning to home screen");
                break;
            default:
                System.out.println("invalid selection, please review your order");
        }
    }
}
