package tests;

import jakarta.persistence.*;
import modele.Medecin;

import java.util.List;

public class TestJPQL5 {

    public static List<Medecin> setSalaire() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();


        List<Medecin> medecins = null;
        try {
            tx.begin();
            // query selection
            medecins = em.createQuery("select m from Medecin m", Medecin.class).getResultList();

            // update query in volume
            em.createQuery("UPDATE Medecin m SET m.salaire = 9855").executeUpdate();

            // On met à jour le contexte de persistance
            for (Medecin medecin : medecins) {
                em.refresh(medecin);
                System.out.println(medecin); // Print the refreshed entity
            }
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        }
        return medecins;
    }
}

