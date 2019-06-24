package entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "serwis")
public class Serwis {

private Magazyn magazyn;
private Zlecenie zlecenie;



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;


    @Column(name ="magazyn_id")
    public Magazyn getMagazyn(){
        return magazyn;
    }
    private int zlecenie_id;


    @Column(name = "zlecenie_id")
    public Zlecenie getZlecenie(){
        return zlecenie;
    }
    private int magazyn_id;

    @Column(name = "status", nullable = false, length = 30)
    private String status;

    @Column(name = "serwisant", nullable = false, length = 30)
    private String serwisant;


    public void setMagazyn(Magazyn magazyn) {
        this.magazyn = magazyn;
    }



    public void setZlecenie(Zlecenie zlecenie) {
        this.zlecenie = zlecenie;
    }

    public int getZlecenie_id() {
        return zlecenie_id;
    }

    public void setZlecenie_id(int zlecenie_id) {
        this.zlecenie_id = zlecenie_id;
    }

    public int getMagazyn_id() {
        return magazyn_id;
    }

    public void setMagazyn_id(int magazyn_id) {
        this.magazyn_id = magazyn_id;
    }

    public Serwis(int zlecenie_id, int magazyn_id) {
        this.zlecenie_id = zlecenie_id;
        this.magazyn_id = magazyn_id;
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
