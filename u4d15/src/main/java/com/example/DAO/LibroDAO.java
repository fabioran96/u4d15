package com.example.DAO;

import com.example.entities.ElementoCatalogo;
import com.example.entities.Libro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class LibroDAO {
    private EntityManager em;

    public LibroDAO(EntityManager em){
        this.em = em;
    }

    public void save(Libro libro){
        try {
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(libro);
            t.commit();
            System.out.println("Libro salvato con successo!");
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
            Libro found = em.find(Libro.class, id);
            if (found != null){
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("Libro eliminato con successo");
            } else {
                System.out.println("Libro non trovato");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Libro findById(long id) {
        return em.find(Libro.class, id);
    }

    public List<Libro> findByAutore(String autore) {
        try {
            return em.createQuery("SELECT l FROM Libro l WHERE l.autore = :autore", Libro.class)
                    .setParameter("autore", autore)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }



}
