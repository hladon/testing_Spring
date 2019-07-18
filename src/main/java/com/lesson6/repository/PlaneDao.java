package com.lesson6.repository;

import com.lesson6.model.Plane;

import javax.persistence.TemporalType;
import java.util.Date;
import java.util.List;
@org.springframework.stereotype.Repository
public class PlaneDao extends Repository<Plane> {

    public Plane findById(int id) {
        return entityManager.find(Plane.class, id);
    }

    public List<Plane> planesProducedBefore(Date date){
        List<Plane> list=entityManager.
                createNamedQuery("SELECT p FROM Plane p WHERE YEAR_PRODUCED BEFORE ?1",Plane.class)
                .setParameter(1,date, TemporalType.TIMESTAMP)
                .getResultList();
        return list;
    }
}
