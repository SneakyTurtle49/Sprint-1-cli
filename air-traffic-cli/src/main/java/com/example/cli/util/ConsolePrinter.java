
package com.example.cli.util;

import com.example.cli.http.models.*;

import java.util.List;

public class ConsolePrinter {

    public static void printAirportsInCity(List<Airport> airports) {
        System.out.println("\nAirports in the selected city:");
        for (Airport a : airports) {
            System.out.printf(" - %s (%s)\n", a.getName(), a.getCode());
        }
    }

    public static void printAircraftForPassenger(List<Aircraft> aircraftList) {
        System.out.println("\nAircraft the passenger has flown on:");
        for (Aircraft ac : aircraftList) {
            System.out.printf(" - %s | Airline: %s | Capacity: %d\n",
                    ac.getType(), ac.getAirlineName(), ac.getNumberOfPassengers());
        }
    }

    public static void printAirportsForAircraft(List<Airport> airports) {
        System.out.println("\nAirports used by the aircraft:");
        for (Airport a : airports) {
            System.out.printf(" - %s (%s)\n", a.getName(), a.getCode());
        }
    }

    public static void printAirportsUsedByPassenger(List<Airport> airports) {
        System.out.println("\nAirports used by the passenger:");
        for (Airport a : airports) {
            System.out.printf(" - %s (%s)\n", a.getName(), a.getCode());
        }
    }
}
