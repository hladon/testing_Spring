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

    public List<Plane> regularPlanes(int year,int regQuantity){
        List<Plane> list=entityManager.
                createNativeQuery("SELECT PLANE.* FROM PLANE\n" +
                        "INNER JOIN (SELECT FLIGHT.PLANE,COUNT(FLIGHT.PLANE) FROM FLIGHT\n" +
                        "WHERE EXTRACT(YEAR FROM FLIGHT.DATE_FLIGHT)=?1\n" +
                        "GROUP BY FLIGHT.PLANE HAVING COUNT(FLIGHT.PLANE)>?2 ) FLIGHT  ON FLIGHT.PLANE=PLANE.ID",Plane.class)
                .setParameter(1,year)
                .setParameter(2,regQuantity)
                .getResultList();
        return list;
    }
}
