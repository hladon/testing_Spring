package com.lesson6.repository;

import com.lesson6.model.Passenger;

import java.util.List;

@org.springframework.stereotype.Repository
public class PassengerDao extends Repository<Passenger> {

    public PassengerDao() {
        type = Passenger.class;
    }

    public List<Passenger> regularPassenger(int year, int flights) {
        List<Passenger> list;
        try {
            list = entityManager.createNativeQuery(
                    "SELECT PASSENGER.* FROM PASSENGER\n" +
                            "INNER JOIN (SELECT STORY.PASSENGER,COUNT(STORY.PASSENGER) FROM STORY\n" +
                            "INNER JOIN FLIGHT ON FLIGHT.ID=STORY.FLIGHT\n" +
                            "AND EXTRACT(YEAR FROM FLIGHT.DATE_FLIGHT)=?1\n" +
                            "GROUP BY STORY.PASSENGER HAVING COUNT(STORY.PASSENGER)>?2 ) STORY  ON STORY.PASSENGER=PASSENGER.ID\n",
                    Passenger.class).
                    setParameter(1, year).
                    setParameter(2, flights).
                    getResultList();
        } catch (Exception e) {
            System.out.println("Some thing wrong with getting data from repository!");
            throw e;
        }
        return list;

    }
}
