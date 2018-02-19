package com.kodilla.exception.test;

import java.io.IOException;
import java.util.HashMap;

public class SearchFlight {


    public boolean findFlight(Flight flight) throws RouteNotFoundException {
        HashMap<String, Boolean> airport = new HashMap<String, Boolean>();
        airport.put("Warszawa", true);
        airport.put("Praga", false);
        airport.put("Poznan", true);
        airport.put("Wrocław", false);

        Boolean canFlight = airport.get(flight.getArrivalAirport());
        if(canFlight == null){
            throw new RouteNotFoundException();
        }
        return canFlight;
    }
    public static void main(String[] args) {
    SearchFlight searchFlight = new SearchFlight();
        try {
            searchFlight.findFlight(new Flight("Poznan", "Wrocław"));
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
        try {
            searchFlight.findFlight(new Flight("Bydgoszcz", "Piła"));
        } catch (RouteNotFoundException e) {
            e.printStackTrace();
        }
    }
    }

