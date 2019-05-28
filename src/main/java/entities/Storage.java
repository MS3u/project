package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Storage {
    private int id;
    private String nazwa;
    private int cenaNetto;
    private int cenaBrutto;
    private int stan;

    public Storage(String text, String text1, String text2, String text3) {
    }

    public Storage(int id, String nazwa, int cenaNetto, int cenaBrutto, int stan) {
        this.id = id;
        this.nazwa = nazwa;
        this.cenaNetto = cenaNetto;
        this.cenaBrutto = cenaBrutto;
        this.stan = stan;
    }

    public Storage() {
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
    @Column(name = "Nazwa", nullable = true, length = 30)
    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    @Basic
    @Column(name = "CenaNetto", nullable = true)
    public int getCenaNetto() {
        return cenaNetto;
    }

    public void setCenaNetto(int cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    @Basic
    @Column(name = "CenaBrutto", nullable = true)
    public int getCenaBrutto() {
        return cenaBrutto;
    }

    public void setCenaBrutto(int cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    @Basic
    @Column(name = "Stan", nullable = true)
    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Storage storage = (Storage) o;
        return id == storage.id &&
                Objects.equals(nazwa, storage.nazwa) &&
                Objects.equals(cenaNetto, storage.cenaNetto) &&
                Objects.equals(cenaBrutto, storage.cenaBrutto) &&
                Objects.equals(stan, storage.stan);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nazwa, cenaNetto, cenaBrutto, stan);
    }
}
