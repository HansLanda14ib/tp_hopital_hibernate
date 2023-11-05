package modele;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String localisation;
    // Service 1..* Medecin
    @OneToMany(mappedBy = "service",fetch = FetchType.LAZY)
    List<Medecin> medecins;
    @ManyToOne
    private Medecin chefService;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getLocalisation() {
        return localisation;
    }

    public void setLocalisation(String localisation) {
        this.localisation = localisation;
    }

    public List<Medecin> getMedecins() {
        return medecins;
    }

    public void setMedecins(List<Medecin> medecins) {
        this.medecins = medecins;
    }

    public Medecin getMedecinChef() {
        return chefService;
    }

    public void setMedecinChef(Medecin medecinChef) {
        this.chefService = medecinChef;
    }
}
