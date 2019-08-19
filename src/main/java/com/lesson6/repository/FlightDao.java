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
        List<Flight> result = null;
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
        try {
            result = entityManager.createQuery(criteria).getResultList();
        } catch (Exception e) {
            System.out.println("Some thing wrong with getting data from repository!");
            throw e;
        }
        return entityManager.createQuery(criteria).getResultList();
    }

    public List<Flight> mostPopularFrom() {
        List<Flight> list = null;
        try {
            list = entityManager.createNativeQuery(
                    "SELECT FLIIGHT.*  FROM FLIGHT \n" +
                    "LEFT JOIN (SELECT CITY_FROM,COUNT(FLIGHT_ID) AS RNK FROM FLIGHT \n" +
                    "GROUP BY CITY_FROM ) CITY_RNK \n" +
                    "ON FLIGHT.CITY_FROM=CITY_RNK.RNK \n"  +
                    "ORDER BY CITY_RNK.RNK DESC ", Flight.class).getResultList();
        } catch (Exception e) {
            System.out.println("Some thing wrong with getting data from repository!");
            throw e;
        }
        return list;
    }

    public List<Flight> mostPopularTo() {
        List<Flight> list = null;
        try {
            list = entityManager.createNativeQuery(
                    "SELECT FLIIGHT.*  FROM FLIGHT \n" +
                    "LEFT JOIN (SELECT CITY_TO,COUNT(FLIGHT_ID) AS RNK FROM FLIGHT \n" +
                    "GROUP BY CITY_TO ) CITY_RNK \n" +
                    "ON FLIGHT.CITY_TO=CITY_RNK.RNK \n"  +
                    "ORDER BY CITY_RNK.RNK DESC ", Flight.class).getResultList();
        } catch (Exception e) {
            System.out.println("Some thing wrong with getting data from repository!");
            throw e;
        }
        return list;
    }
}
