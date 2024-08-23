package com.example.DAO;

import com.example.entities.ElementoCatalogo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

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
}
