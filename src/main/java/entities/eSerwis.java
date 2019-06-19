package entities;

import javax.persistence.*;

@Entity
@Table(name = "serwis")
public class eSerwis {
    private int id;
    private String nrZlecenia;
    private String status;
    private String serwisant;

    public eSerwis() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    @Column(name = "nrZlecenia", nullable = true, length = 30)
    public String getNrZlecenia() {
        return nrZlecenia;
    }

    public void setNrZlecenia(String nrZlecenia) {
        this.nrZlecenia = nrZlecenia;
    }

    @Column(name = "status", nullable = true, length = 30)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Column(name = "serwisant",nullable = true, length = 30)
    public String getSerwisant() {
        return serwisant;
    }

    public void setSerwisant(String serwisant) {
        this.serwisant = serwisant;
    }



    public eSerwis(String nrZlecenia, String status, String serwisant) {
        this.nrZlecenia = nrZlecenia;
        this.status = status;
        this.serwisant = serwisant;
    }

    public eSerwis(int id, String nrZlecenia, String status, String serwisant) {
        this.id = id;
        this.nrZlecenia = nrZlecenia;
        this.status = status;
        this.serwisant = serwisant;
    }
}