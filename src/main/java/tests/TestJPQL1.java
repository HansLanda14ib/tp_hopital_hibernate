package tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modele.Medecin;

import java.util.List;

public class TestJPQL1 {

    public static List<Medecin> findMedecinByService(String service) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Medecin> medecins = em.createQuery("select m from Medecin m where m.service.nom = :service", Medecin.class)
                .setParameter("service", service.toUpperCase())
                .getResultList();
        tx.commit();
        em.close();
        emf.close();
        return medecins;
    }

}
