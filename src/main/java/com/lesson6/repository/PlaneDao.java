package com.lesson6.repository;

import com.lesson6.model.Plane;

import java.util.List;

public class PlaneDao extends Repository<Plane> {

    public Plane findById(int id) {
        return entityManager.find(Plane.class, id);
    }

    public List<Plane> selectAll(){
        List<Plane> list=entityManager.createNativeQuery("SELECT * FROM PLANE ",Plane.class).getResultList();
        return list;
    }
}
