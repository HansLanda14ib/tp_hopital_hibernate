package tests;

import jakarta.persistence.*;

import java.util.List;

public class TestJPQL3 {
    public static List<String> findMedecinByChef(String nomChef, String prenomChef) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        Query query = em.createNamedQuery("Medecin.findByChef");
        query.setParameter("nomChef", nomChef);
        query.setParameter("prenomChef", prenomChef);
        List<String> medecins = query.getResultList();
        tx.commit();
        em.close();
        emf.close();
        return medecins;
    }
}
