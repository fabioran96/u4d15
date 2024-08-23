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

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            Prestito found = em.find(Prestito.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Prestito eliminato con successo!");
            } else {
                System.out.println("Prestito non trovato");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }



}
