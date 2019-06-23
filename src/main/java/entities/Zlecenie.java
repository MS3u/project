package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "zlecenie")
public class Zlecenie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;
    @NotNull(message = "required")

    @Column(name = "nr", unique = true)
    private String nr;

    @NotNull(message = "required")
    @Size(min = 5 , max = 255)
    @Column(name = "imie")
    private String imie;
    @NotNull

    @Column(name = "nazwisko")
    private String nazwisko;



    @NotNull
    @Column(name = "pesel")
    private String pesel;
    @NotNull
    @Column(name = "telefon")
    private String telefon;

    @Column(name = "opis")
    private String opis;

    @Column(name = "data")
    private String data;

    @OneToMany(mappedBy = "user")
    private List<Orders> orders;

    public Zlecenie() {
    }

    /**
     * Class constructor
     * @param login
     * @param password

     */
    public Zlecenie(String nr, String imie, String nazwisko, String pesel, String telefon, String opis, String data) {
        this.nr = nr;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.telefon = telefon;
        this.opis = opis;
        this.data = data;
    }

    /**
     * Getters and setters
     * @return
     */
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNr() {
        return nr;
    }
    public String getImie() {
        return imie;
    }
    public String getNazwisko() {
        return nazwisko;
    }
    public String getPesel() {
        return pesel;
    }
    public String getTelefon() {
        return telefon;
    }
    public String getOpis() {
        return opis;
    }

    public void setNr(String nr) {
        this.nr = nr;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return nr + " " + nazwisko;
    }
}
