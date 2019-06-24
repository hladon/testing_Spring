package com.lesson6.repository;

import com.lesson6.model.Plane;

import java.util.List;

public class PlaneDao extends Repository<Plane> {

    public Plane findById(int id) {
        return entityManager.find(Plane.class, id);
    }

    public List<Plane> selectByRequest(String query){
        List<Plane> list=entityManager.createNativeQuery(query,Plane.class).getResultList();
        return list;
    }
}
