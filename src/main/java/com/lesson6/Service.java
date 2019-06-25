package com.lesson6;

import com.lesson6.model.Plane;
import com.lesson6.repository.PlaneDao;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Service {

    @Autowired
    private PlaneDao planeDao;

    public List<Plane> oldPlanes(){
        List<Plane> planeList=planeDao.selectAll();
        List<Plane> planes;
        LocalDate localDate=LocalDate.now();
        LocalDate dateTwentyEgo=localDate.minusYears(20);
        for(Plane plane:planeList){
            long diff=plane.getYearProduced().getTime()-new Date().getTime();
            if(TimeUnit.DAYS.convert((plane.getYearProduced().getTime()-new Date().getTime()),TimeUnit.MILLISECONDS)))

        }
    }
}
