package com.lesson6.repository;

import com.lesson6.model.Passenger;
import com.lesson6.model.Plane;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
@org.springframework.stereotype.Repository
public class PlaneDao extends Repository<Plane> {

    public PlaneDao() {
        this.type=Plane.class;
    }

    public List<Plane> regularPlanes(){
        List<Plane> list=entityManager.createNamedQuery(
                "SELECT CITY_TO, COUNT(CITY_TO) AS val " +
                        "FROM FLIGHT GROUP BY CITY_TO ORDER BY val DESC",Plane.class).getResultList();
        return list;
    }

    public List<Plane> planesProducedBefore(Date date){
        List<Plane> list=entityManager.createNativeQuery(
                "SELECT *, COUNT(story.flight) count1 FROM PLANE \n" +
                        "JOIN STORY ON story.id=passenger.id\n" +
                        "JOIN FLIGHT ON flight.id=story.flight\n" +
                        "AND EXTRACT(YEAR FROM flight.date_flight)=?1\n" +
                        "GROUP BY passenger.last_name HAVING COUNT(story.flight)>?2",Plane.class).
                setParameter(1,year).
                setParameter(2,flights).
                getResultList();
        return list;
    }
}
