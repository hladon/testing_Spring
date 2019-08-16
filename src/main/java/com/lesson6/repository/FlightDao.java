package com.lesson6.repository;

import com.lesson6.model.Filter;
import com.lesson6.model.Flight;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@org.springframework.stereotype.Repository
public class FlightDao extends Repository<Flight> {

    public FlightDao() {
        type = Flight.class;
    }

    public List<Flight> flightsByDate(Filter filter) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Flight> criteria = builder.createQuery(Flight.class);
        Root<Flight> root = criteria.from(Flight.class);
        criteria.select(root);
        List<Predicate> predicates = new ArrayList<Predicate>();
        if (filter.getCityFrom() != null) {
            predicates.add(builder.like(root.get("cityFrom"), filter.getCityFrom()));
        }
        if (filter.getCityTo() != null) {
            predicates.add(builder.like(root.get("cityTo"), filter.getCityTo()));
        }
        predicates.add(builder.between(root.get("dateFlight"), filter.getDateFrom(), filter.getDateTo()));
        criteria.where(predicates.toArray(new Predicate[]{}));
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<Flight> mostPopularFrom() {
        List<Flight> list = entityManager.createNativeQuery("SELECT * FROM (\n" +
                "SELECT *  FROM FLIGHT \n" +
                "INNER JOIN (SELECT STORY.FLIGHT,COUNT(STORY.FLIGHT) AS PAS FROM STORY \n" +
                "GROUP BY STORY.FLIGHT )\n" +
                "STORY ON STORY.FLIGHT=FLIGHT.ID) FL\n" +
                "INNER JOIN (\n" +
                "SELECT FLIGHT.CITY_FROM,MAX(PAS) MPAS FROM FLIGHT \n" +
                "INNER JOIN (SELECT STORY.FLIGHT,COUNT(STORY.FLIGHT) AS PAS FROM STORY \n" +
                "GROUP BY STORY.FLIGHT )\n" +
                "STORY ON STORY.FLIGHT=FLIGHT.ID\n" +
                "GROUP BY FLIGHT.CITY_FROM) MFL\n" +
                "ON FL.CITY_FROM=MFL.CITY_FROM AND\n" +
                "FL.PAS=MFL.MPAS \n" +
                "ORDER BY PAS DESC", Flight.class).getResultList();
        return list;
    }

    public List<Flight> mostPopularTo() {
        List<Flight> list = entityManager.createNativeQuery("SELECT * FROM (\n" +
                "SELECT *  FROM FLIGHT \n" +
                "INNER JOIN (SELECT STORY.FLIGHT,COUNT(STORY.FLIGHT) AS PAS FROM STORY \n" +
                "GROUP BY STORY.FLIGHT )\n" +
                "STORY ON STORY.FLIGHT=FLIGHT.ID) FL\n" +
                "INNER JOIN (\n" +
                "SELECT FLIGHT.CITY_TO,MAX(PAS) MPAS FROM FLIGHT \n" +
                "INNER JOIN (SELECT STORY.FLIGHT,COUNT(STORY.FLIGHT) AS PAS FROM STORY \n" +
                "GROUP BY STORY.FLIGHT )\n" +
                "STORY ON STORY.FLIGHT=FLIGHT.ID\n" +
                "GROUP BY FLIGHT.CITY_TO) MFL\n" +
                "ON FL.CITY_TO=MFL.CITY_TO AND\n" +
                "FL.PAS=MFL.MPAS \n" +
                "ORDER BY PAS DESC", Flight.class).getResultList();
        return list;
    }
}
