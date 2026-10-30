package com.rest.CLI;

import com.rest.models.Payment;
import com.rest.payment.*;
import com.rest.service.PaymentService;

import java.util.Scanner;

public class PaymentCli {

    private final PaymentService service;

    public PaymentCli() {
        service = new PaymentService();
    }

    public Payment makePayment(double amount, Scanner scanner) {

        System.out.println("\n=== PAYMENT ===");
        System.out.println("1. Cash");
        System.out.println("2. Card");
        System.out.println("3. UPI");

        System.out.print("Select payment method: ");

        int choice = scanner.nextInt();

        PaymentMethod method;

        switch (choice) {

            case 1:
                method = new CashPayment();
                break;

            case 2:
                method = new CardPayment();
                break;

            case 3:
                method = new UPIPayment();
                break;

            default:
                System.out.println("Invalid payment method.");
                return null;
        }

        Payment payment = service.processPayment(method, amount);

        System.out.println("\nPayment successful!");
        System.out.println(payment);

        return payment;
    }
}