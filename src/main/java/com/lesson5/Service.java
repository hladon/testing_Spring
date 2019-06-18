package com.lesson5;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.InputStream;

@org.springframework.stereotype.Service
public class Service {

    private DAO dao;

    @Autowired
    public Service(DAO dao) {
        this.dao = dao;
    }

    public String save(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = null;
        try {
            item = objectMapper.readValue(inputStream, Item.class);
        } catch (Exception e) {
            return e.getMessage();
        }

        return dao.save(item);
    }

    public String delete(String id) {
        Integer intId = Integer.parseInt(id);
        if (intId != 0) {
            dao.delete(intId);
            return "Delete  done!";
        }
        return "Wrong id input";

    }

    public String update(InputStream inputStream) {
        ObjectMapper objectMapper = new ObjectMapper();
        Item item = null;
        try {
            item = objectMapper.readValue(inputStream, Item.class);

        } catch (Exception e) {
            return e.getMessage();
        }
        dao.save(item);
        return "Save  done";
    }

}
