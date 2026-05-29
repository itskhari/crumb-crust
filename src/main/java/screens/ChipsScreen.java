package screens;

import borders.UI;
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
        UI.header("🍟 ADD CHIPS");

        String flavor = chooseChips();
        if (flavor == null) return;

        Chips chips = new Chips(flavor);
        order.addItem(chips);

        UI.success("\n🍟 Chips added to order!\n");
    }

    // chips
    private String chooseChips() {

        while (true) {
            UI.sub("Choose Your Chips:");

            UI.option(1, "BBQ", "🔥");
            UI.option(2, "Sour Cream & Onion", "🧅");
            UI.option(3, "Salt & Vinegar", "🧂");
            UI.option(4, "Jalapeno", "🌶️");
            UI.option(5, "Plain", "🍟");
            UI.option(0, "Return to Order Menu", "↩️");

            UI.prompt("Enter your choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1": return "BBQ";
                case "2": return "Sour Cream & Onion";
                case "3": return "Salt & Vinegar";
                case "4": return "Jalapeno";
                case "5": return "Plain";
                case "0": return null;
                default:
                    UI.warn("invalid selection, please try again.\n");
            }
        }
    }
}

