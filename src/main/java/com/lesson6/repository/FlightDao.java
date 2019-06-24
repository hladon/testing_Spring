package com.lesson6.repository;

import com.lesson6.model.Flight;

public class FlightDao extends Repository<Flight>{

    public Flight findById(int id) {
        return entityManager.find(Flight.class, id);
    }
}
