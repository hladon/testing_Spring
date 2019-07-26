package com.lesson6;

import com.lesson6.model.Filter;
import com.lesson6.model.Flight;
import com.lesson6.model.Plane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private Service service;

    public List<Flight> flightByDate(Filter filter){
        return null;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/oldPlanes",produces = "text/plain")
    public @ResponseBody String oldPlanes(){
        String returnData="";
        for (Plane plane: service.oldPlanes()){
            returnData+=plane+"/n";

        }
        return returnData;
    }
}
