package com.example;

import com.example.DAO.LibroDAO;
import com.example.DAO.PrestitoDAO;
import com.example.DAO.UtenteDAO;
import com.example.entities.Libro;
import com.example.entities.Utente;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4d15");


    public static void main(String[] args) {
        //System.out.println("Hello World!");
        EntityManager em = emf.createEntityManager();

        LibroDAO libroDAO = new LibroDAO(em);
        UtenteDAO utenteDAO = new UtenteDAO(em);
        PrestitoDAO prestitoDAO = new PrestitoDAO(em);

        try {
            Libro libro = new Libro("Harry Potter e la pietra filosofale", 1997, 324, "J.K. Rowling", "Fantasy");
            libroDAO.save(libro);

            Libro libro1= new Libro("Il Codice Da Vinci", 2003, 525, "Dan Brown", "Thriller");
            libroDAO.save(libro1);

            Utente utente = new Utente("Fabio", "Ranocchiari", java.time.LocalDate.of(1996,6,24),"ABC123");
            utenteDAO.save(utente);

            Utente utente1 = new Utente("Mario", "Rossi", java.time.LocalDate.of(2000,3,12),"ABC124");
            utenteDAO.save(utente1);
        } finally {
            em.close();
            emf.close();
        }



    }
}
