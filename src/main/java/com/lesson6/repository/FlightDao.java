package com.lesson6.repository;

import com.lesson6.model.Flight;
import com.lesson6.model.Plane;

import java.util.List;
@org.springframework.stereotype.Repository
public class FlightDao extends Repository<Flight>{

    public Flight findById(int id) {
        return entityManager.find(Flight.class, id);
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

    public List<String> mostPopularFrom(){
        List<String> list=entityManager.createNativeQuery("SELECT CITY_FROM, COUNT(CITY_FROM) AS val FROM FLIGHT GROUP BY CITY_FROM ORDER BY val DESC",String.class).getResultList();
        return list;
    }

    public List<String> mostPopularTo(){
        List<String> list=entityManager.createNativeQuery("SELECT CITY_TO, COUNT(CITY_TO) AS val FROM FLIGHT GROUP BY CITY_TO ORDER BY val DESC",String.class).getResultList();
        return list;
    }

    public List<Plane> regularPlanes(){
        List<Plane> list=entityManager.createNamedQuery("SELECT CITY_TO, COUNT(CITY_TO) AS val FROM FLIGHT GROUP BY CITY_TO ORDER BY val DESC",Plane.class).getResultList();
        return list;
    }
}
