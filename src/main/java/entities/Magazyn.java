package entities;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
@Table(name = "magazyn")
public class Magazyn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "nazwa", nullable = false, length = 30)
    private String nazwa;

    @Column(name = "stan", nullable = false, length = 30)
    @Min(0)
    private int stan;



    public Magazyn(String nazwa, int stan) {
        this.nazwa = nazwa;
        this.stan = stan;
    }

    public Magazyn(int stan) {
        this.stan = stan;
    }

    public Magazyn() {
    }

    public Magazyn(int id,String nazwa, int stan) {
        this.id = id;
        this.nazwa = nazwa;
        this.stan = stan;
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

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }



    @Override
    public String toString() {
        return nazwa;
    }


}
