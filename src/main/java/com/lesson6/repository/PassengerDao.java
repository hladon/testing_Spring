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
                    "SELECT * FROM PASSENGER WHERE EXISTS\n" +
                            "(SELECT * FROM STORY \n" +
                            "JOIN FLIGHT ON STORY.FLIGHT=FLIGHT.ID\n" +
                            "WHERE STORY.PASSENGER =PASSENGER.ID AND EXTRACT (YEAR FROM FLIGHT.DATE_FLIGHT)=?1\n" +
                            "GROUP BY STORY.PASSENGER \n" +
                            "HAVING COUNT(DISTINCT FLIGHT.ID)>=?2)",
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
