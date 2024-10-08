package com.example.DAO;

import com.example.entities.ElementoCatalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class ElementoCatalogoDAO {
    private EntityManager em;

    public ElementoCatalogoDAO(EntityManager em){
        this.em = em;
    }

    public void save(ElementoCatalogo elemento){
        try{
            EntityTransaction t = em.getTransaction();
            t.begin();
            em.persist(elemento);
            t.commit();
            System.out.println("ElementoCatalogo salvato con successo!");
        } catch (Exception e){
            System.out.println(e.getMessage());

            if ((em.getTransaction().isActive())) {
                em.getTransaction().rollback();
            }
        }
    }

    public void delete(long id) {
        try {
            EntityTransaction t = em.getTransaction();
            ElementoCatalogo found = em.find(ElementoCatalogo.class, id);
            if (found != null) {
                t.begin();
                em.remove(found);
                t.commit();
                System.out.println("ElementoCatalogo eliminato con successo!");
            } else {
                System.out.println("ElementoCatalogo non trovato");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public ElementoCatalogo findById(long id) {
        return em.find(ElementoCatalogo.class, id);
    }

    public List<ElementoCatalogo> findByAnnoPubblicazione(int annoPubblicazione) {
        try {
            return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.annoPubblicazione = :anno", ElementoCatalogo.class)
                    .setParameter("anno", annoPubblicazione)
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<ElementoCatalogo> findByTitolo(String titolo) {
        try {
            return em.createQuery("SELECT e FROM ElementoCatalogo e WHERE e.titolo LIKE :titolo", ElementoCatalogo.class)
                    .setParameter("titolo", "%" + titolo + "%")
                    .getResultList();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }





}
