package screens;

import borders.UI;
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
        UI.header("🥤 QUENCH YOUR THIRST");

        String size = chooseSize();
        String flavor = chooseFlavor();

        Drink drink = new Drink(size, flavor);
            order.addItem(drink);
            UI.success("\n🥤 Drink added to order!\n");

    }

          //drink
          private String chooseSize() {
            while (true) {
                UI.sub("Choose Drink Size:");

                UI.option(1, "Small", "🥛");
                UI.option(2, "Medium", "🧃");
                UI.option(3, "Large", "🥤");

                UI.prompt("Enter your choice: ");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1": return "Small";
                    case "2": return "Medium";
                    case "3": return "Large";
                    default:
                        UI.warn("invalid selection, please try again\n");
                }
            }
    }

           // flavor
           private String chooseFlavor() {
            while (true) {
                UI.sub("Choose Drink Flavor:");

                UI.option(1, "Coke", "🥤");
                UI.option(2, "Sprite", "🍋");
                UI.option(3, "Root Beer", "🪵");
                UI.option(4, "Lemonade", "🍋");
                UI.option(5, "Sweet Tea", "🧋");
                UI.option(6, "Unsweet Tea", "🧋");

                UI.prompt("Enter your choice: ");
                String choice = sc.nextLine();

                switch (choice) {
                    case "1": return "Coke";
                    case "2": return "Sprite";
                    case "3": return "Root Beer";
                    case "4": return "Lemonade";
                    case "5": return "Sweet Tea";
                    case "6": return "Unsweet Tea";
                    default:
                        UI.warn("invalid selection. please try again.\n");
                }
            }
    }
}

