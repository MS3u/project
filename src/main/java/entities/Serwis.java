package entities;

import javax.persistence.*;

@Entity
@Table(name = "serwis")
public class Serwis {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;

    @ManyToOne
    @JoinColumn(name = "magazyn_id")
    public Magazyn magazyn;

    @Column(name = "status", nullable = false, length = 30)
    private String status;




    @Column(name = "zlecenie_id")
    private int zlecenie_id;


    @Column(name = "serwisant", nullable = false, length = 30)
    private String serwisant;


    public Serwis(Magazyn magazyn, String status, int zlecenie_id, String serwisant) {
        this.magazyn = magazyn;
        this.status = status;
        this.zlecenie_id = zlecenie_id;
        this.serwisant = serwisant;
    }

    public int getZlecenie_id() {
        return zlecenie_id;
    }

    public void setZlecenie_id(int zlecenie_id) {
        this.zlecenie_id = zlecenie_id;
    }

    public Magazyn getMagazyn() {
        return magazyn;
    }

    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }

    public Serwis(int zlecenie_id, Magazyn magazyn) {
        this.zlecenie_id = zlecenie_id;
        this.magazyn = magazyn;
    }

    public Serwis() {
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

    public String getSerwisant() {
        return serwisant;
    }

    public void setSerwisant(String serwisant) {
        this.serwisant = serwisant;
    }
}