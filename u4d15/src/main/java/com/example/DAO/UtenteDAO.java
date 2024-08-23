package com.example.DAO;

import com.example.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class UtenteDAO {
    private EntityManager em;

    public UtenteDAO(EntityManager em){
        this.em = em;
    }

    public void save(Utente utente){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(utente);
            t.commit();
        } catch (Exception e){
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }
}
