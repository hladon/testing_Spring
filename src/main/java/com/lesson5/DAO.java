package com.lesson5;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.io.InputStream;

@Repository
@Transactional
public class DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(InputStream inputStream) {
        ObjectMapper objectMapper=new ObjectMapper();
        Item item=null;
        try {
            item=objectMapper.readValue(inputStream,Item.class);
        }catch (Exception e){
            return "Save  failed!";
        }
        entityManager.persist(item);
        return "Save  done";
    }

    public String delete(String id) {
        Integer intId = Integer.parseInt(id);
        if (intId!=0){
            entityManager.remove(entityManager.find(Item.class, intId));
            return "Delete  done!";
        }
        return "Wrong id input";

    }

    public String update(InputStream inputStream){
        ObjectMapper objectMapper=new ObjectMapper();
        Item item=null;
        try {
            item=objectMapper.readValue(inputStream,Item.class);

        }catch (Exception e){
            return "Update  failed!";
        }
        entityManager.merge(item);
        return "Save  done";
    }


}
