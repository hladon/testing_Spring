package com.lesson6;

import com.lesson6.model.Plane;
import com.lesson6.repository.PlaneDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;


public class Service {

    @Autowired
    private PlaneDao planeDao;

    public List<Plane> oldPlanes(){
        List<Plane> planeList=planeDao.selectAll();
        List<Plane> planes=null;
        long lifeTime=20*315569250*100;// 20 years in miliseconds
        for(Plane plane:planeList){
            long diff=plane.getYearProduced().getTime()-new Date().getTime();
            if(diff>lifeTime){
                planes.add(plane);
            }
        }
        return planes;
    }


}
