package com.lesson6.repository;

import com.lesson6.model.Flight;

import java.util.List;

public class FlightDao extends Repository<Flight>{

    public Flight findById(int id) {
        return entityManager.find(Flight.class, id);
    }
    public List<Flight> selectAll(){
        List<Flight> list=entityManager.createNativeQuery("SELECT * FROM FLIGHT ",Flight.class).getResultList();
        return list;
    }

    public List<Flight> selectBycityFrom(String city){
        List<Flight> list=entityManager.createQuery("SELECT Flight FROM FLIGHT WHERE CITY_FROM =:city",Flight.class)
                .setParameter("city",city)
                .getResultList();
        return list;
    }

}
