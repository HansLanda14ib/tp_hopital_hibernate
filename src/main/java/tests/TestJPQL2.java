package tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modele.Medecin;

import java.util.List;

public class TestJPQL2 {

    public static List<Object[]> findMedecinByService2(String service) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        List<Object[]> medecins = em.createQuery("SELECT m.salaire, m.nom FROM Medecin m WHERE m.service.nom = :service", Object[].class)
                .setParameter("service", service.toUpperCase())
                .getResultList();
        tx.commit();
        em.close();
        emf.close();
        return medecins;
    }
}
