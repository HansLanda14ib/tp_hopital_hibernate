package modele;

import com.sun.istack.NotNull;
import jakarta.persistence.*;

@Entity
public class Adresse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int number;
    @NotNull
    private String street;
    @NotNull
    private String city;
    private int zipCode;

    public Adresse(String street, String city, int zipCode) {

        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
    }

    public Adresse() {

    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipCode() {
        return zipCode;
    }

    public void setZipCode(int zipCode) {
        this.zipCode = zipCode;
    }
}
