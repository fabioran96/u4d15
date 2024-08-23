package com.example.DAO;

import com.example.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em){
        this.em = em;
    }

    private void save(Libro libro){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(libro);
            t.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
}
