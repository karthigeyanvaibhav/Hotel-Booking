package com.rest.CLI;

import java.util.Scanner;

public class MenuCli {

    private final Scanner scanner = new Scanner(System.in);

    public void start() {

        int choice;

        do {
            System.out.println("\n=== MENU MANAGEMENT ===");
            System.out.println("1. View Menu");
            System.out.println("0. Back");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.println("View Menu");
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