import com.rest.CLI.RestaurantCli;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        RestaurantCli restaurantCli = new RestaurantCli(scanner);

        restaurantCli.start();

        scanner.close();
    }
}