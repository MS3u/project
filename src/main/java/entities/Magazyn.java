package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "magazyn")
public class Magazyn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "nazwa", nullable = false, length = 30)
    private String nazwa;

    @Column(name = "cena", nullable = false, length = 30)
    private String cena;








    public Magazyn(String nazwa, String cena) {
        this.nazwa = nazwa;
        this.cena = cena;
    }

    public Magazyn() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getCena() {
        return cena;
    }

    public void setCena(String cena) {
        this.cena = cena;
    }



    @Override
    public String toString() {
        return nazwa;
    }
}
