
package com.example.cli;

import com.example.cli.http.ApiClient;
import com.example.cli.util.ConsolePrinter;

import java.util.Scanner;

public class App {
    private static final Scanner scanner = new Scanner(System.in);
    private static final ApiClient apiClient = new ApiClient();

    public static void main(String[] args) {
        int choice;
        do {
            printMenu();
            choice = getUserChoice();
            handleChoice(choice);
        } while (choice != 0);
        System.out.println("Goodbye!");
    }

    private static void printMenu() {
        System.out.println("\n==== Air Traffic CLI ====");
        System.out.println("1. View airports in each city");
        System.out.println("2. View aircraft each passenger has flown on");
        System.out.println("3. View airports aircraft take off from and land at");
        System.out.println("4. View airports passengers have used");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }

    private static int getUserChoice() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void handleChoice(int choice) {
        switch (choice) {
            case 1 -> {
                System.out.print("Enter City ID: ");
                Long cityId = Long.parseLong(scanner.nextLine());
                ConsolePrinter.printAirportsInCity(apiClient.getAirportsInCity(cityId));
            }
            case 2 -> {
                System.out.print("Enter Passenger ID: ");
                Long passengerId = Long.parseLong(scanner.nextLine());
                ConsolePrinter.printAircraftForPassenger(apiClient.getAircraftForPassenger(passengerId));
            }
            case 3 -> {
                System.out.print("Enter Aircraft ID: ");
                Long aircraftId = Long.parseLong(scanner.nextLine());
                ConsolePrinter.printAirportsForAircraft(apiClient.getAirportsForAircraft(aircraftId));
            }
            case 4 -> {
                System.out.print("Enter Passenger ID: ");
                Long passengerId = Long.parseLong(scanner.nextLine());
                ConsolePrinter.printAirportsUsedByPassenger(apiClient.getAirportsUsedByPassenger(passengerId));
            }
            case 0 -> {}
            default -> System.out.println("Invalid option. Please try again.");
        }
    }
}
