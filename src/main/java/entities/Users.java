package entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
public class Users {
    private  String s;
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private String haslo;

    public Users() {
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "imie", nullable = false, length = 30)
    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    @NotNull
    @Size(min = 2 , max = 30)
    @Column(name = "nazwisko", nullable = false, length = 30)
    public String getNazwisko() {
        return nazwisko;
    }


    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    @Column(name = "stanowisko", nullable = false, length = 30)
    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    @NotNull(message = "required")
    @Size(min = 5 , max = 255)
    @Column(name = "haslo", nullable = false, length = 30)
    public String getHaslo() {
        return haslo;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }


    public Users(String imie, String nazwisko, String stanowisko, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.haslo = haslo;
    }

    public Users(String s) {
        this.s = s;
    }

    public Users(String nazwisko, String haslo) {
        this.nazwisko = nazwisko;
        this.haslo = haslo;
    }

    public Users(int id, String imie, String nazwisko, String stanowisko, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.haslo = haslo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return id == users.id &&
                Objects.equals(imie, users.imie) &&
                Objects.equals(nazwisko, users.nazwisko) &&
                Objects.equals(stanowisko, users.stanowisko) &&
                Objects.equals(haslo, users.haslo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imie, nazwisko, stanowisko, haslo);
    }
}
