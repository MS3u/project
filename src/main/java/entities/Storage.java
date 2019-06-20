package entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Storage {
    private int id;
    private String nazwa;
    private float cenaNetto;
    private float cenaBrutto;
    private int stan;


    public Storage(String nazwa, float cenaNetto, float cenaBrutto, int stan) {
        this.nazwa = nazwa;
        this.cenaNetto = cenaNetto;
        this.cenaBrutto = cenaBrutto;
        this.stan = stan;
    }

    public Storage(int id, String nazwa, float cenaNetto, float cenaBrutto, int stan) {
        this.id = id;
        this.nazwa = nazwa;
        this.cenaNetto = cenaNetto;
        this.cenaBrutto = cenaBrutto;
        this.stan = stan;
    }

    public Storage(int stan) {
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
    public float getCenaNetto() {
        return cenaNetto;
    }
    public void setCenaNetto(float cenaNetto) {
        this.cenaNetto = cenaNetto;
    }

    @Basic
    @Column(name = "CenaBrutto", nullable = true)
    public float getCenaBrutto() {
        return cenaBrutto;
    }
    public void setCenaBrutto(float cenaBrutto) {
        this.cenaBrutto = cenaBrutto;
    }

    @Basic
    @Column(name = "Stan", nullable = true)
    @NotNull(message = "wymagane")
    @Range(min = 1, max=100)
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
