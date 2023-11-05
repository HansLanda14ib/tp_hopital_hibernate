package modele;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Malade extends Personne{

    @Id
    private int id;
    @OneToOne
    private Adresse adresse;


    public Malade() {
        super();
    }

    public Malade(String nom, String prenom, Adresse adresse) {
        super(nom, prenom);
        this.adresse = adresse;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

}
