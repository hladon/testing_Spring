package com.lesson6;

import com.lesson6.model.Filter;
import com.lesson6.model.Flight;
import com.lesson6.model.Passenger;
import com.lesson6.model.Plane;
import com.lesson6.repository.FlightDao;
import com.lesson6.repository.PassengerDao;
import com.lesson6.repository.PlaneDao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private PlaneDao planeDao;

    @Autowired
    private FlightDao flightDao;

    @Autowired
    private PassengerDao passengerDao;

    public List<Plane> oldPlanes(){
        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        int year  = localDate.getYear();
        int yearProduced=year-20;
        return planeDao.planesProducedBefore(yearProduced);
    }

    public List<Flight> flightsByDate(Filter filter){

        return flightDao.flightsByDate(filter);
    }

    public List<Passenger> regularPassengers(int year){
        int numberOfFlights=25;
        return passengerDao.regularPassenger(year,numberOfFlights);
    }

    public List<Plane> regularPlanes(int year){
        int numberOfFlights=25;
        return planeDao.regularPlanes(year,numberOfFlights);
    }

    public List<Flight> mostPopularTo(){
        return flightDao.mostPopularTo();
    }

    public List<Flight> mostPopularFrom(){
        return flightDao.mostPopularFrom();
    }

}
