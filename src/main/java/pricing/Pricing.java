package pricing;

public class Pricing {
    public static double getBasePrice(int size) {
        switch(size) {
            case 4: return 5.50;
            case 8: return 7.00;
            case 12: return 8.50;
            default: return 0;
        }
    }

    public static double getMeatPrice(int size) {
        switch(size) {
            case 4: return 1.00;
            case 8: return 2.00;
            case 12: return 3.00;
            default: return 0;
        }
    }

    public static double getExtraMeatPrice(int size) {
        switch(size) {
            case 4: return 0.50;
            case 8: return 1.00;
            case 12: return 1.50;
            default: return 0;
        }
    }

    public static double getCheesePrice(int size) {
        switch(size) {
            case 4: return 0.75;
            case 8: return 1.50;
            case 12: return 2.25;
            default: return 0;
        }
    }

    public static double getExtraCheesePrice(int size) {
        switch(size) {
            case 4: return 0.30;
            case 8: return 0.60;
            case 12: return 0.90;
            default: return 0;
        }
    }
}
