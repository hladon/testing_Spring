package com.lesson6.repository;

import com.lesson6.model.Passenger;

import java.util.List;
@org.springframework.stereotype.Repository
public class PassengerDao extends Repository<Passenger> {

    public PassengerDao() {
        this.type=Passenger.class;
    }

    public List<Passenger> regularPassenger(int year, int flights){
        return entityManager.createNativeQuery(
                "SELECT *, COUNT(story.flight) count1 FROM PASSENGER \n" +
                        "JOIN STORY ON story.id=passenger.id\n" +
                        "JOIN FLIGHT ON flight.id=story.flight\n" +
                        "AND EXTRACT(YEAR FROM flight.date_flight)=?1\n" +
                        "GROUP BY passenger.last_name HAVING COUNT(story.flight)>?2",
                Passenger.class).
                setParameter(1,year).
                setParameter(2,flights).
                getResultList();
    }
}
