package com.lesson6.repository;

import com.lesson6.model.Plane;


import java.util.List;
@org.springframework.stereotype.Repository
public class PlaneDao extends Repository<Plane> {

    public PlaneDao() {
        type=Plane.class;
    }

    public List<Plane> planesProducedBefore(int year){
        List<Plane> list=entityManager.
                createNativeQuery("SELECT * FROM PLANE WHERE EXTRACT(YEAR FROM YEAR_PRODUCED)<?1",Plane.class)
                .setParameter(1,year)
                .getResultList();
        return list;
    }
}
