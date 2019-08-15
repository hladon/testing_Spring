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
        DateTime date=new DateTime();
        Date dateProduced=date.minusYears(20).toDate();
        return planeDao.planesProducedBefore(dateProduced);
    }

    public List<Flight> flightsByDate(Filter filter){
        return null;
    }

    public List<Passenger> regularPassenger(int year){
        int regQuantity=3;
        return passengerDao.regularPassenger(year,regQuantity);
    }

    public List<Plane> regularPlanes(int year){
        return planeDao.regularPlanes(year);
    }

    public List<String> mostPopularTo(){
        return flightDao.mostPopularTo();
    }

    public List<String> mostPopularFrom(){
        return flightDao.mostPopularFrom();
    }

}
