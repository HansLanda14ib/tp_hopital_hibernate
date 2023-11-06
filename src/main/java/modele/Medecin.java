package modele;

import jakarta.persistence.*;

import java.util.List;

@NamedQuery(name = "Medecin.findByChef",
        query = "SELECT m.nom FROM Medecin m WHERE m.medecinChef.nom = :nomChef AND m.medecinChef.prenom = :prenomChef")

@Entity
public class Medecin extends Personne {
    private double salaire;

    @ManyToOne
    private Service service;

    @OneToMany(mappedBy = "chefService", fetch = FetchType.LAZY)
    List<Service> services;


    @ManyToOne
    private Medecin medecinChef;


    @OneToMany(mappedBy = "medecin", fetch = FetchType.LAZY)
    private List<Participation> participations;

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    public Medecin(String nom, String prenom, double salaire) {
        super(nom, prenom);
        this.salaire = salaire;
    }

    public Medecin() {
        super();
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Medecin getMedecinChef() {
        return medecinChef;
    }

    public void setMedecinChef(Medecin medecinChef) {
        this.medecinChef = medecinChef;
    }


    @Override
    public String toString() {
        return "Medecin{" + this.getNom() + " " + this.getPrenom() +
                ", salaire=" + this.getSalaire() +
                '}';
    }
}
