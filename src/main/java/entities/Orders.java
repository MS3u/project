package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Orders {
    private int id;
    private String nrZlecenia;
    private String dataPrzyjecia;
    private String imie;
    private String nazwisko;
    private String miasto;
    private String ulica;
    private String nrDomu;
    private String nrLokalu;
    private String nip;
    private String opis;
    private String serwisant;



    public Orders(String dataPrzyjecia, String nrZlecenia, String imie, String nazwisko, String miasto, String ulica, String nrDomu, String nrLokalu, String nip, String opis, String serwisant) {
        this.dataPrzyjecia = dataPrzyjecia;
        this.nrZlecenia = nrZlecenia;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.miasto = miasto;
        this.ulica = ulica;
        this.nrDomu = nrDomu;
        this.nrLokalu = nrLokalu;
        this.nip = nip;
        this.opis = opis;
        this.serwisant = serwisant;
    }



    public Orders(int id, String dataPrzyjeciaText, String nrZleceniaText, String imieText, String nazwiskoTextskoT, String miastoTexttoT, String ulicaTextcaT, String nrDomuText, String nrLokauText, String nipText, String opiStext, String serwisantText) {
        this.id =id;
        this.dataPrzyjecia = dataPrzyjeciaText;
        this.nrZlecenia = nrZleceniaText;
        this.imie = imieText;
        this.nazwisko = nazwiskoTextskoT;
        this.miasto = miastoTexttoT;
        this.ulica = ulicaTextcaT;
        this.nrDomu = nrDomuText;
        this.nrLokalu = nrLokauText;
        this.nip = nipText;
        this.opis = opiStext;
        this.serwisant = serwisantText;
    }

    public Orders() {
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "nrZlecenia", nullable = false, length = 30)
    public String getNrZlecenia() {
        return nrZlecenia;
    }

    public void setNrZlecenia(String nrZlecenia) {
        this.nrZlecenia = nrZlecenia;
    }


    @Column(name = "dataPrzyjecia")
    public String getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(String dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }


    @Column(name = "imie", length = 30)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }


    @Column(name = "nazwisko", nullable = true, length = 30)
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    @Column(name = "miasto", nullable = true, length = 30)
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }


    @Column(name = "ulica", nullable = true, length = 30)
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }


    @Column(name = "nrDomu", nullable = true, length = 30)
    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }


    @Column(name = "nrLokalu", nullable = true, length = 30)
    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }


    @Column(name = "NIP", nullable = true, length = 30)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }


    @Column(name = "opis")
    public String getOpis() {
        return opis;
    }
    public void setOpis(String opis) {
        this.opis = opis;
    }


    @Column(name = "serwisant")
    public String getSerwisant() {
        return serwisant;
    }
    public void setSerwisant(String serwisant) {
        this.opis = serwisant;
    }




}