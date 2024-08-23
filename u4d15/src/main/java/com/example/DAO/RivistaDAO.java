package com.example.DAO;

import com.example.entities.Rivista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class RivistaDAO {
    private EntityManager em;

    public RivistaDAO(EntityManager em){
        this.em = em;
    }

    public void save(Rivista rivista){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(rivista);
            t.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()){
                em.getTransaction().rollback();
            }
        }
    }
}
