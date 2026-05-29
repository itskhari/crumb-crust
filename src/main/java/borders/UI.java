package borders;

public class UI {
        public static final String RESET = "\u001B[0m";
        public static final String CYAN = "\u001B[36m";
        public static final String GREEN = "\u001B[32m";
        public static final String YELLOW = "\u001B[33m";
        public static final String PURPLE = "\u001B[35m";
        public static final String BOLD = "\u001B[1m";

        public static void header(String title) {
            System.out.println(PURPLE + BOLD);
            System.out.println("====================================");
            System.out.println("        " + title);
            System.out.println("====================================" + RESET);
            System.out.println();
        }

        public static void sub(String text) {
            System.out.println(PURPLE + BOLD + text + RESET);
        }

        public static void divider() {
            System.out.println("------------------------------------");
        }

        public static void option(int number, String text, String emoji) {
            System.out.println(CYAN + number + ") " + emoji + " " + text + RESET);
        }

        public static void success(String msg) {
            System.out.println(GREEN + msg + RESET);
        }

        public static void warn(String msg) {
            System.out.println(YELLOW + msg + RESET);
        }

        public static void prompt(String text) {
            System.out.print(CYAN + text + RESET);
        }
    }
