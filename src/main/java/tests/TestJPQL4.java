package tests;

import jakarta.persistence.*;
import modele.Medecin;

import java.util.List;

import static tests.TestJPQL1.findMedecinByService;

public class TestJPQL4 {

    public static List<Medecin> updateMedecinsByService(String nomService) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        final EntityTransaction et = em.getTransaction();
        List<Medecin> medecins = em.createQuery("select m from Medecin m where m.service.nom = :service", Medecin.class)
                .setParameter("service", nomService.toUpperCase())
                .getResultList();
        try {
            et.begin();
            for (Medecin medecin : medecins) {
                medecin.setSalaire(medecin.getSalaire() * 1.05);
                //em.merge(medecin);

            }
            et.commit();
            em.close(); // Close the EntityManager
        } catch (Exception ex) {
            et.rollback();

        }
        return medecins;
    }
}
