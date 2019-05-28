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

    public Orders(String dataPrzyjecia, String nrZlecenia, String imie, String nazwisko, String miasto, String ulica, String nrDomu, String nrLokalu, String nip, String opis) {
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

    @Basic
    @Column(name = "nrZlecenia", nullable = false, length = 30)
    public String getNrZlecenia() {
        return nrZlecenia;
    }

    public void setNrZlecenia(String nrZlecenia) {
        this.nrZlecenia = nrZlecenia;
    }

    @Basic
    @Column(name = "dataPrzyjecia")
    public String getDataPrzyjecia() {
        return dataPrzyjecia;
    }

    public void setDataPrzyjecia(String dataPrzyjecia) {
        this.dataPrzyjecia = dataPrzyjecia;
    }

    @Basic
    @Column(name = "imie", length = 30)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @Basic
    @Column(name = "nazwisko", nullable = true, length = 30)
    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Basic
    @Column(name = "miasto", nullable = true, length = 30)
    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    @Basic
    @Column(name = "ulica", nullable = true, length = 30)
    public String getUlica() {
        return ulica;
    }

    public void setUlica(String ulica) {
        this.ulica = ulica;
    }

    @Basic
    @Column(name = "nrDomu", nullable = true, length = 30)
    public String getNrDomu() {
        return nrDomu;
    }

    public void setNrDomu(String nrDomu) {
        this.nrDomu = nrDomu;
    }

    @Basic
    @Column(name = "nrLokalu", nullable = true, length = 30)
    public String getNrLokalu() {
        return nrLokalu;
    }

    public void setNrLokalu(String nrLokalu) {
        this.nrLokalu = nrLokalu;
    }

    @Basic
    @Column(name = "NIP", nullable = true, length = 30)
    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @Basic
    @Column(name = "Opis", nullable = true, length = 200)
    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Orders orders = (Orders) o;
        return id == orders.id &&
                Objects.equals(nrZlecenia, orders.nrZlecenia) &&
                Objects.equals(dataPrzyjecia, orders.dataPrzyjecia) &&
                Objects.equals(imie, orders.imie) &&
                Objects.equals(nazwisko, orders.nazwisko) &&
                Objects.equals(miasto, orders.miasto) &&
                Objects.equals(ulica, orders.ulica) &&
                Objects.equals(nrDomu, orders.nrDomu) &&
                Objects.equals(nrLokalu, orders.nrLokalu) &&
                Objects.equals(nip, orders.nip) &&
                Objects.equals(opis, orders.opis);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nrZlecenia, dataPrzyjecia, imie, nazwisko, miasto, ulica, nrDomu, nrLokalu, nip, opis);
    }
}
