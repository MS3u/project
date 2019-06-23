package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "magazyn")
public class Magazyn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @Column(name = "nazwa")
    @NotNull
    @Size(min = 2 , max = 40)
    private String nazwa;

    @Column(name = "cena")
    @NotNull
    @Size(min = 2 , max = 40)
    private String cena;

    @NotNull
    @Column(name = "stan")
    private int stan;

    @OneToOne(mappedBy = "book")
    private Orders orders;

    public Magazyn(String nazwa, String cena, int stan) {
        this.nazwa = nazwa;
        this.cena = cena;
        this.stan = stan;
    }

    /**
     * Class constructor
     * @param
     * @param
     * @param
     */






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

    public int getStan() {
        return stan;
    }

    public void setStan(int stan) {
        this.stan = stan;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }

    /**
     * Getters and setters
     * @return
     */


    @Override
    public String toString() {
        return nazwa;
    }
}
