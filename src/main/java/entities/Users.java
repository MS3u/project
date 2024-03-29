package entities;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
public class Users {
    private int id;
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private String haslo;


    public Users() {
    }
    public Users(String s){
        this.stanowisko= s;

    }

    /**
     * Getters and Setters
     * @return
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true)
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "Imie")
    @NotNull(message ="wymagane")
    @Size(min = 2, max= 20)

    public String getImie() {
        return imie;
    }
    public void setImie(String imie) {
        this.imie = imie;
    }


    @Column(name = "Nazwisko")
    @NotNull(message ="wymagane")
    @Size(min = 2, max= 20)
    public String getNazwisko() {
        return nazwisko;
    }
    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }


    @Column(name = "Stanowisko")
    @NotNull(message ="wymagane")
    @Size(min = 2, max= 10)
    public String getStanowisko() {
        return stanowisko;
    }
    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }



    @Column(name = "Haslo")
    @NotNull(message = "wymagane")
    @Size(min = 5 , max = 255)
    public String getHaslo() {
        return haslo;
    }
    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    /**
     * Konstruktor klasy
     * @param id
     * @param imie
     * @param nazwisko
     * @param stanowisko
     * @param haslo
     */
    public Users(int id, String imie, String nazwisko, String stanowisko, String haslo) {
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.haslo = haslo;
    }

    public Users(String imie, String nazwisko, String stanowisko, String haslo) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.haslo = haslo;
    }
    public Users(String nazwisko,String haslo){
        this.nazwisko= nazwisko;
        this.haslo = haslo;

    }


@Override
public String toString(){
        return imie +" "+nazwisko;
}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        if (id != users.id) return false;
        if (imie != null ? !imie.equals(users.imie) : users.imie != null) return false;
        if (nazwisko != null ? !nazwisko.equals(users.nazwisko) : users.nazwisko != null) return false;
        if (stanowisko != null ? !stanowisko.equals(users.stanowisko) : users.stanowisko != null) return false;
        if (haslo != null ? !haslo.equals(users.haslo) : users.haslo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (imie != null ? imie.hashCode() : 0);
        result = 31 * result + (nazwisko != null ? nazwisko.hashCode() : 0);
        result = 31 * result + (stanowisko != null ? stanowisko.hashCode() : 0);
        result = 31 * result + (haslo != null ? haslo.hashCode() : 0);
        return result;
    }
}
