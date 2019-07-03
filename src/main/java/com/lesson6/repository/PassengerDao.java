package com.lesson6.repository;

import com.lesson6.model.Passenger;

import java.util.List;

public class PassengerDao extends Repository<Passenger> {

    public Passenger findById(int id) {
        return entityManager.find(Passenger.class, id);
    }

    public List<Passenger> regularPassenger(int year){
        List<Passenger> list=entityManager.createNamedQuery("SELECT p FROM Passenger WHERE YEAR(p.)")
    }
}
