package com.lesson6;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lesson6.model.Filter;
import com.lesson6.model.Flight;
import com.lesson6.model.Passenger;
import com.lesson6.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


import java.io.InputStream;


@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    @RequestMapping(method = RequestMethod.POST, value = "/oldPlanes", produces = "text/plain",
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String flightByDate(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        Filter filter = null;

        try {
            filter = objectMapper.readValue(inputStream, Filter.class);
        } catch (Exception e) {
            System.out.println("Wrong mapping");
            return e.getMessage();
        }
        System.out.println(filter);
        String returnData = "";
        for (Flight flight : service.flightsByDate(filter)) {
            returnData += flight.toString() + "\n";

        }

        return returnData;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/filter", produces = "text/plain")
    public @ResponseBody
    String oldPlanes() {
        String returnData = "";
        for (Plane plane : service.oldPlanes()) {
            returnData += plane.toString() + "\n";
        }
        return returnData;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/regPass", produces = "text/plain")
    public @ResponseBody
    String regularPassengers(@RequestParam(name = "year") int year) {
        String returnData = "";
        for (Passenger passenger : service.regularPassengers(year)) {
            returnData += passenger.toString() + "\n";
        }
        return returnData;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/regPlanes", produces = "text/plain")
    public @ResponseBody
    String regularPlanes(@RequestParam(name = "year") int year) {
        String returnData = "";
        for (Plane plane : service.regularPlanes(year)) {
            returnData += plane.toString() + "\n";

        }
        return returnData;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/popularTo", produces = "text/plain")
    public @ResponseBody
    String mostPopularTo() {
        String returnData = "";
        for (Flight flight : service.mostPopularTo()) {
            returnData += flight.toString() + "\n";

        }
        return returnData;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/popularFrom", produces = "text/plain")
    public @ResponseBody
    String mostPopularFrom() {
        String returnData = "";
        for (Flight flight : service.mostPopularFrom()) {
            returnData += flight.toString() + "\n";

        }
        return returnData;
    }
}
