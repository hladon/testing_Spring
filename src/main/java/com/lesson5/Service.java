package com.lesson5;


import org.springframework.beans.factory.annotation.Autowired;


@org.springframework.stereotype.Service
public class Service {

    private DAO dao;

    @Autowired
    public Service(DAO dao) {
        this.dao = dao;
    }

    public String save(Item item) {
        if (dao.checkExistance(item) || dao.findById(item.getId()) != null) {
            return "Such object exist";
        }
        return dao.save(item);
    }

    public String delete(int id) {
        Item item = dao.findById(id);
        if (item != null) {
            return dao.delete(item);
        }
        return "Item don`t exist in storage";

    }

    public String update(Item item) {
        if (dao.findById(item.getId()) == null) {
            return "Such object don`t exist";
        }
        return dao.update(item);
    }


}
