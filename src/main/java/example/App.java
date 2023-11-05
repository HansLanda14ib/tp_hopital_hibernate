package example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import modele.Adresse;
import modele.Malade;
import modele.Medecin;
import tests.TestJPQL4;
import tests.TestJPQL5;

import java.util.List;

import static tests.TestJPQL1.findMedecinByService;
import static tests.TestJPQL2.findMedecinByService2;
import static tests.TestJPQL3.findMedecinByChef;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {

      /*  EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hospital");
        EntityManager em = entityManagerFactory.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
           Adresse adr1 = new Adresse("rue de la paix", "Paris", 75000);
            em.persist(adr1);
            Malade mal1 = new Malade("Proviste", "Alain", adr1);
            //Malade mal2 = new Malade("Trahuil", "Badr");
            //Medecin med1 = new Medecin("benchekroun", "Yasmine", 10000);
            et.begin();
           em.persist(adr1);
            em.persist(mal1);
            //em.persist(mal2);
            et.commit();
        } finally {
            if (et.isActive()) {
                et.rollback();
            }
            em.close();
            entityManagerFactory.close();
        } */

        // Question 4
        //List<Medecin> medecins=findMedecinByService("Traumato");

        //  Question 5
      /*  List<Object[]> medecins=findMedecinByService2("Cardiologie");
        for (Object[] medecin : medecins) {
            System.out.println("Salaire: " + medecin[0] + ", Nom: " + medecin[1]);
        } */

        // Question 6
       /* List<String> doctors=findMedecinByChef("benbakrim", "hicham");

        for (String doctor : doctors) {
            System.out.println(doctor);
        } */

        // Question 7
      /* List<Medecin> medecins=TestJPQL4.updateMedecinsByService("Cardiologie");
        System.out.println("Done");
        System.out.println(medecins); */
        // Question 8

        System.out.println("Done");
        List<Medecin> medecins =TestJPQL5.setSalaire();
        System.out.println(medecins);



    }
}