package com.example.DAO;

import com.example.entities.ElementoCatalogo;
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
            System.out.println("Utente salvato con successo!");

        } catch (Exception e){
            System.out.println(e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    public void delete(long id){
        try {
            EntityTransaction t = em.getTransaction();
            Utente found = em.find(Utente.class, id);
            if (found != null){
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Utente eliminato con successo");
            } else {
                System.out.println("Utente non trovato");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Utente findById(long id) {
        return em.find(Utente.class, id);
    }



}
