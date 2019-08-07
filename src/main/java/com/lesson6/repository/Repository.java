package com.lesson6.repository;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@org.springframework.stereotype.Repository
@Transactional
public class Repository<T> {

    @PersistenceContext
    protected EntityManager entityManager;

    Class<T> type;

    public T findById(int id) {
        return entityManager.find(type, id);
    }

    public String save(T item) {
        entityManager.persist(item);
        return "Save  done";
    }

    public String delete(T item) {
        entityManager.remove(item);
        return "Delete  done!";
    }

    public String update(T item) {
        entityManager.merge(item);
        return "Update  done";
    }

}
