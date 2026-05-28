package com.pluralsight;

import screens.HomeScreen;

import java.util.Scanner;

public class POS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HomeScreen home = new HomeScreen(sc);
        home.show();

        sc.close();
        System.out.println("end");
    }

}
