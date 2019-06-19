package com.lesson5;


import org.springframework.stereotype.Repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;


@Repository
@Transactional
public class DAO {

    @PersistenceContext
    private EntityManager entityManager;

    public String save(Item item) {
        entityManager.persist(item);
        return "Save  done";
    }

    public String delete(Item item) {
        entityManager.remove(item);
        return "Delete  done!";
    }

    public String update(Item item) {
        entityManager.merge(item);
        return "Save  done";
    }

    public Item findById(int id) {
        return entityManager.find(Item.class, id);
    }

    public boolean checkExistance(Item item) {
        return entityManager.contains(item);
    }


}
