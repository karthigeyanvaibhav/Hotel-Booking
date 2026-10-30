package com.rest.CLI;

import java.util.Scanner;

public class OrderCli {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n=== ORDER MANAGEMENT ===");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("0. Back");

            System.out.print("Enter choice: ");
            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Create Order");
                    break;

                case 2:
                    System.out.println("View Orders");
                    break;

                case 0:
                    System.out.println("Back to Main Menu");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }
}