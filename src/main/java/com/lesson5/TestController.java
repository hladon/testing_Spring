package com.lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import java.io.InputStream;


@Controller
public class TestController {

    private DAO dao;

    @Autowired
    public TestController(DAO dao) {
        this.dao = dao;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/save",produces = "text/plain",consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String save (InputStream inputStream){
        return dao.save(inputStream);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/delete",produces = "text/plain")
    public @ResponseBody
    String delete (@RequestParam(name="id") String id){
        return dao.delete(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item/update",produces = "text/plain")
    public @ResponseBody
    String update (InputStream inputStream) {
        return dao.update(inputStream);
    }
}
