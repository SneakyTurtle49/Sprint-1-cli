
package com.example.cli.http;

import com.example.cli.http.models.*;
import com.example.cli.http.parser.ResponseParser;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class ApiClient {
    private static final String BASE_URL = "http://localhost:8080";

    private String getJsonResponse(String endpoint) {
        try {
            URL url = new URL(BASE_URL + endpoint);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            StringBuilder response = new StringBuilder();
            String output;
            while ((output = br.readLine()) != null) {
                response.append(output);
            }
            conn.disconnect();
            return response.toString();
        } catch (Exception e) {
            System.out.println("Failed to fetch data: " + e.getMessage());
            return "[]";
        }
    }

    public List<Airport> getAirportsInCity(Long cityId) {
        String json = getJsonResponse("/cities/" + cityId + "/airports");
        Type listType = new TypeToken<List<Airport>>(){}.getType();
        return ResponseParser.parseList(json, listType);
    }

    public List<Aircraft> getAircraftForPassenger(Long passengerId) {
        String json = getJsonResponse("/passengers/" + passengerId + "/aircraft");
        Type listType = new TypeToken<List<Aircraft>>(){}.getType();
        return ResponseParser.parseList(json, listType);
    }

    public List<Airport> getAirportsForAircraft(Long aircraftId) {
        String json = getJsonResponse("/aircraft/" + aircraftId + "/airports");
        Type listType = new TypeToken<List<Airport>>(){}.getType();
        return ResponseParser.parseList(json, listType);
    }

    public List<Airport> getAirportsUsedByPassenger(Long passengerId) {
        String json = getJsonResponse("/passengers/" + passengerId + "/airports");
        Type listType = new TypeToken<List<Airport>>(){}.getType();
        return ResponseParser.parseList(json, listType);
    }
}
