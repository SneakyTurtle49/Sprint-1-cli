
package com.example.cli;

import com.example.cli.http.ApiClient;
import com.example.cli.http.models.Airport;
import com.example.cli.http.models.Aircraft;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ApiClientTest {

    private final ApiClient apiClient = new ApiClient();

    @Test
    public void testGetAirportsInCity() {
        List<Airport> airports = apiClient.getAirportsInCity(1L);
        assertNotNull(airports);
    }

    @Test
    public void testGetAircraftForPassenger() {
        List<Aircraft> aircraftList = apiClient.getAircraftForPassenger(1L);
        assertNotNull(aircraftList);
    }

    @Test
    public void testGetAirportsForAircraft() {
        List<Airport> airports = apiClient.getAirportsForAircraft(1L);
        assertNotNull(airports);
    }

    @Test
    public void testGetAirportsUsedByPassenger() {
        List<Airport> airports = apiClient.getAirportsUsedByPassenger(1L);
        assertNotNull(airports);
    }
}
