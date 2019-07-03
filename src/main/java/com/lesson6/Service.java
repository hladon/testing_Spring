package com.lesson6;

import com.lesson6.model.Filter;
import com.lesson6.model.Flight;
import com.lesson6.model.Passenger;
import com.lesson6.model.Plane;
import com.lesson6.repository.FlightDao;
import com.lesson6.repository.PlaneDao;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class Service {

    @Autowired
    private PlaneDao planeDao;

    @Autowired
    private FlightDao flightDao;

    public List<Plane> oldPlanes(){
        DateTime date=new DateTime();
        Date dateProduced=date.minusYears(20).toDate();
        return planeDao.planesProducedBefore(dateProduced);
    }

    public List<Flight> flightsByDate(Filter filter){

    }

    public Passenger regularPassenger(int year){

    }

    public List<Plane> regularPlanes(int year){

    }

    public List<String> mostPopularTo(){
        return flightDao.mostPopularTo();
    }

    public List<String> mostPopularFrom(){
        return flightDao.mostPopularFrom();
    }

}
