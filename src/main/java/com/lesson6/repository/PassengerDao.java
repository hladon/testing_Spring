package com.lesson6.repository;

import com.lesson6.model.Passenger;

public class PassengerDao extends Repository<Passenger> {

    public Passenger findById(int id) {
        return entityManager.find(Passenger.class, id);
    }
}
