package com.lesson6;

import com.lesson6.model.Plane;
import com.lesson6.repository.PlaneDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class Service {

    @Autowired
    private PlaneDao planeDao;

    public List<Plane> oldPlanes(){
        return planeDao.selectByRequest("SELECT FROM PLANE WHERE  ")
    }
}
