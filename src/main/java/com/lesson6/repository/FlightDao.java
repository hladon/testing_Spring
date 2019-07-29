package com.lesson6.repository;

import com.lesson6.model.Flight;

import java.util.List;
@org.springframework.stereotype.Repository
public class FlightDao extends Repository<Flight>{

    public FlightDao() {
        type=Flight.class;
    }

    public List<Flight> selectAll(){
        List<Flight> list=entityManager.createNativeQuery("SELECT * FROM FLIGHT ",Flight.class).getResultList();
        return list;
    }

    public List<Flight> selectBycityFrom(String city){
        List<Flight> list=entityManager.createNamedQuery("SELECT Flight FROM Flight WHERE CITY_FROM =:city",Flight.class)
                .setParameter("city",city)
                .getResultList();
        return list;
    }

    public List<Flight> mostPopularFrom(){
        List<Flight> list=entityManager.createNativeQuery("SELECT CITY_FROM, COUNT(CITY_FROM) AS val FROM FLIGHT GROUP BY CITY_FROM ORDER BY val DESC",Flight.class).getResultList();
        return list;
    }

    public List<Flight> mostPopularTo(){
        List<Flight> list=entityManager.createNativeQuery("SELECT CITY_TO, COUNT(CITY_TO) AS val FROM FLIGHT GROUP BY CITY_TO ORDER BY val DESC",Flight.class).getResultList();
        return list;
    }
}
