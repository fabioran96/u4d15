package com.example.DAO;

import com.example.entities.ElementoCatalogo;
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

    public void delete(long id){
        try {
            EntityTransaction t = em.getTransaction();
            Rivista found = em.find(Rivista.class, id);
            if (found != null){
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Rivista eliminata con successo!");
            } else {
                System.out.println("Rivista non trovata");
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Rivista findById(long id) {
        return em.find(Rivista.class, id);
    }

}
