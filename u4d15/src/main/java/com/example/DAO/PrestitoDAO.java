package com.example.DAO;

import com.example.entities.Prestito;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class PrestitoDAO {
    private EntityManager em;

    public PrestitoDAO(EntityManager em) {
        this.em = em;
    }

    public void save(Prestito prestito) {
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(prestito);
            t.commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }


}
