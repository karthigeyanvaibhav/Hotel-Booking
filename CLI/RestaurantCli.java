package com.rest.CLI;

import com.rest.models.Bill;
import com.rest.models.Menu;
import com.rest.models.Order;
import com.rest.models.Payment;
import com.rest.models.Table;
import com.rest.service.BillService;
import com.rest.service.MenuService;
import com.rest.service.OrderService;
import com.rest.service.TableServices;

import java.util.Scanner;

public class RestaurantCli {

    private final Scanner scanner;

    private final TableServices tableService;
    private final MenuService menuService;
    private final OrderService orderService;
    private final BillService billService;
    private final PaymentCli paymentCli;

    public RestaurantCli(Scanner scanner) {

        this.scanner = scanner;

        tableService = new TableServices();
        menuService = new MenuService();
        orderService = new OrderService();
        billService = new BillService();
        paymentCli = new PaymentCli();
    }

    public void start() {

        int choice;

        do {

            System.out.println("\n=================================");
            System.out.println("       RESTAURANT SYSTEM");
            System.out.println("=================================");
            System.out.println("1. View Tables");
            System.out.println("2. View Menu");
            System.out.println("3. Place Order");
            System.out.println("4. View Orders");
            System.out.println("0. Exit");

            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    viewTables();
                    break;

                case 2:
                    viewMenu();
                    break;

                case 3:
                    placeOrder();
                    break;

                case 4:
                    viewOrders();
                    break;

                case 0:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 0);
    }

    private void viewTables() {

        System.out.println("\n========== TABLES ==========");

        for (Table table : tableService.getAll()) {
            System.out.println(table);
        }
    }

    private void viewMenu() {

        System.out.println("\n========== MENU ==========");

        for (Menu menu : menuService.getAll()) {
            System.out.println(menu);
        }
    }

    private void placeOrder() {

        System.out.println("\n========== SELECT TABLE ==========");

        for (Table table : tableService.getAll()) {

            System.out.println(
                    "Table " + table.getId() +
                    " | Capacity: " + table.getCapasity() +
                    " | Status: " + table.getStatus()
            );
        }

        System.out.print("\nEnter table ID: ");

        int tableId = scanner.nextInt();

        Table table = tableService.getById(tableId);

        if (table == null) {

            System.out.println("Table not found.");
            return;
        }

        if (table.getStatus() == Table.Availability.occupy) {

            System.out.println("Sorry, this table is already occupied.");
            return;
        }

        tableService.bookTable(tableId);

        System.out.println("\nTable " + tableId + " selected.");

        Order order = orderService.createOrder(tableId);

        int choice;

        do {

            System.out.println("\n========== MENU ==========");

            for (Menu menu : menuService.getAll()) {
                System.out.println(menu);
            }

            System.out.println("0. Finish Order");

            System.out.print("\nEnter food item ID: ");

            choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }

            Menu menu = menuService.getById(choice);

            if (menu == null) {

                System.out.println("Invalid food item.");
                continue;
            }

            System.out.print("Enter quantity: ");

            int quantity = scanner.nextInt();

            if (quantity <= 0) {

                System.out.println("Quantity must be greater than 0.");
                continue;
            }

            orderService.addItem(order, menu, quantity);

            System.out.println(
                    menu.getName() +
                    " added successfully."
            );

        } while (true);

        if (order.getItems().isEmpty()) {

            System.out.println("No items selected.");
            tableService.freeTable(tableId);
            return;
        }

        System.out.println("\n========== ORDER ==========");
        System.out.println(order);

        System.out.print("\nConfirm order? (1 = Yes, 2 = No): ");

        int confirm = scanner.nextInt();

        if (confirm != 1) {

            System.out.println("Order cancelled.");
            tableService.freeTable(tableId);
            return;
        }

        System.out.println("\nOrder placed successfully!");

        Bill bill = billService.generateBill(order);

        System.out.println(bill);

        System.out.println("\nProceed to payment?");

        System.out.println("1. Yes");
        System.out.println("2. No");

        System.out.print("Enter choice: ");

        int paymentChoice = scanner.nextInt();

        if (paymentChoice == 1) {

            Payment payment = paymentCli.makePayment(
                    bill.getTotalAmount(),
                    scanner
            );

            if (payment != null) {

                System.out.println("\n=================================");
                System.out.println("       ORDER COMPLETED");
                System.out.println("=================================");

                System.out.println("Order ID: " + order.getId());
                System.out.println("Table ID: " + order.getTableId());
                System.out.println("Bill Total: Rs. " + bill.getTotalAmount());
                System.out.println("Payment: " + payment.getMethod());
                System.out.println("Status: " + payment.getStatus());

                tableService.freeTable(tableId);

                System.out.println("\nTable " + tableId + " is now free.");
            }

        } else {

            System.out.println("Payment pending.");
            System.out.println("Table remains occupied.");
        }
    }

    private void viewOrders() {

        System.out.println("\n========== ALL ORDERS ==========");

        if (orderService.getAll().isEmpty()) {

            System.out.println("No orders found.");
            return;
        }

        for (Order order : orderService.getAll()) {
            System.out.println(order);
        }
    }
}