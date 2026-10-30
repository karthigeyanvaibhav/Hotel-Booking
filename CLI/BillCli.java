package com.rest.CLI;

import java.util.Scanner;

public class BillCli {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n=== BILL MANAGEMENT ===");
            System.out.println("1. Generate Bill");
            System.out.println("2. View Bill");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("Generate Bill");
                    break;

                case 2:
                    System.out.println("View Bill");
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