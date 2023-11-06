package tests;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modele.Equipe;
import modele.Medecin;
import modele.Participation;

public class Test4 {
    public static void main(String[] args) {

        Equipe eq1 = new Equipe("equipe 1");
        Equipe eq2 = new Equipe("equipe 2");
        Medecin med1 = new Medecin("Benbakrim", "hicham", 15000);
        Medecin med2 = new Medecin("Ghazi", "sara", 25000);
        Medecin med3 = new Medecin("Barri", "jaouad", 17000);
        Medecin med4 = new Medecin("Bakassi", "houda", 12000);
        Participation part1 = new Participation(med1, eq1, "chirurgien");
        Participation part2 = new Participation(med1, eq2, "assistant chirurgien");
        Participation part3 = new Participation(med2, eq1, "anesthésiste");
        Participation part4 = new Participation(med3, eq2, "cardiologue");
        Participation part5 = new Participation(med4, eq1, "interne");
        Participation part6 = new Participation(med4, eq2, "interne");


        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        try {
            tx.begin();
            em.persist(eq1);
            em.persist(eq2);
            em.persist(med1);
            em.persist(med2);
            em.persist(med3);
            em.persist(med4);
            em.persist(part1);
            em.persist(part2);
            em.persist(part3);
            em.persist(part4);
            em.persist(part5);
            em.persist(part6);
            tx.commit();
            em.close(); // Close the EntityManager
        } catch (Exception ex) {
            tx.rollback();

        }

    }
}