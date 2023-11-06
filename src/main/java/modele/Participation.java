package modele;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String fonction;

    @ManyToOne
    private Medecin medecin;

    @ManyToOne
    private Equipe equipe;

    public Participation(Medecin medecin, Equipe equipe, String fonction) {
        this.fonction = fonction;
        this.medecin = medecin;
        this.equipe = equipe;
    }

    public Participation() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Medecin getMedecin() {
        return medecin;
    }

    public void setMedecin(Medecin medecin) {
        this.medecin = medecin;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Participation that = (Participation) o;
        return id == that.id && Objects.equals(fonction, that.fonction) && Objects.equals(medecin, that.medecin) && Objects.equals(equipe, that.equipe);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, fonction, medecin, equipe);
    }

    @Override
    public String toString() {
        return "Participation{" +
                "id=" + id +
                ", fonction='" + fonction + '\'' +
                ", medecin=" + medecin +
                ", equipe=" + equipe +
                '}';
    }
}
