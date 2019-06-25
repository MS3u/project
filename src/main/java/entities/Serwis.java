package entities;

import javax.persistence.*;

@Entity
@Table(name = "serwis")
public class Serwis {


    @ManyToOne
    @JoinColumn(name = "magazyn_id")
    public Magazyn magazyn;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;
    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @ManyToOne
    @JoinColumn(name = "zlecenie_id")
    private Zlecenie zlecenie;

    @ManyToOne
    @JoinColumn(name = "serwisant_id")
    private Users users;


    public Serwis(Magazyn magazyn, String status, Zlecenie zlecenie, Users users) {
        this.magazyn = magazyn;
        this.status = status;
        this.zlecenie = zlecenie;
        this.users = users;
    }

    public Serwis(Zlecenie zlecenie, Magazyn magazyn) {
        this.zlecenie = zlecenie;
        this.magazyn = magazyn;
    }

    public Serwis() {
    }

    public Zlecenie getZlecenie() {
        return zlecenie;
    }

    public void setZlecenie(Zlecenie zlecenie) {
        this.zlecenie = zlecenie;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}