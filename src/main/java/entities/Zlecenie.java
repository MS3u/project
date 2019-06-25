package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "zlecenie")
public class Zlecenie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;



    @Column(name = "imie", nullable = false, length = 30)
    private String imie;

    @Column(name = "nazwisko", nullable = false, length = 30)
    private String nazwisko;

    @Column(name = "pesel", nullable = false, length = 30)
    private String pesel;

    @Column(name = "telefon", nullable = false, length = 30)
    private String telefon;

    @Column(name = "opis", nullable = false, length = 30)
    private String opis;
    @Column(name = "data", nullable = false, length = 30)
    private String data;


    public void setId(int id) {
        this.id = id;
    }



    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }


    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public Zlecenie(String dataPrzyjeciaText, String imie, String nazwisko, String pesel, String telefon, String opis) {
        this.data = dataPrzyjeciaText;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.pesel = pesel;
        this.telefon = telefon;
        this.opis = opis;
    }

    public Zlecenie() {
    }


}
