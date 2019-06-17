package com.lesson1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
@Service
public class ItemService {
    @Autowired
    private  ItemDAO itemDAO=new ItemDAO();
    public  void create(Item item){
        item.setDateCreated(new Date());
        item.setLastUpdatedDate(new Date());
        itemDAO.save(item);
    }
    public  String read(String param){
        int id=Integer.parseInt(param);
        Item item=itemDAO.findById(id);
        return item.toString();
    }
    public  void update(Item item){
        item.setLastUpdatedDate(new Date());
        itemDAO.update(item);

    }
    public  void delete(String id){
        itemDAO.deleteById(Integer.parseInt(id));
    }
}
