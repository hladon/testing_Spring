package com.lesson5;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.io.InputStream;


@Controller
public class TestController {

    private Service service;

    @Autowired
    public TestController(Service service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, value = "/item/save", produces = "text/plain", consumes = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    String save(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = null;
        try {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e) {
            return e.getMessage();
        }
        return service.save(item);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/item/delete", produces = "text/plain")
    public @ResponseBody
    String delete(@RequestParam(name = "id") String id) {
        Integer intId = Integer.parseInt(id);
        if (intId != 0) {
            service.delete(intId);
            return "Delete  done!";
        }
        return "Wrong id input";

    }

    @RequestMapping(method = RequestMethod.PUT, value = "/item/update", produces = "text/plain")
    public @ResponseBody
    String update(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = null;
        try {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e) {
            return e.getMessage();
        }
        return service.update(item);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/delete",produces = "text/plain")
    public @ResponseBody void deleteByName(@RequestParam(name="name") String name){
        service.deleteByName(name);
    }
}
