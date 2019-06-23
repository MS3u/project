package entities;

import javax.persistence.*;



@Entity
@Table(name = "orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private int id;
    @ManyToOne
    @JoinColumn(name = "user_Id")
    private Zlecenie user;
    @OneToOne
    @JoinColumn(name = "book_id")
    private Magazyn book;
    @Column(name = "serwisant")
    private String serwisant;
    @Column(name = "status")
    private String status;

    public Orders(int id, Magazyn book, String serwisant, String status){
        this.id = id;
        this.user = user;
        this.book = book;
        this.serwisant = serwisant;
        this.status = status;
    }

    public Orders(String status) {
        this.status = status;
    }

    public Orders() {
    }

    /**
     * Class constructor
     * @param user
     * @param book
     * @param z
     */

    public Orders(Zlecenie user, Magazyn book, String z) {
        this.user = user;
        this.book = book;
        this.status =z;

    }

    /**
     * Getters and setters
     * @return
     */

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

    public Zlecenie getUser() {
        return user;
    }

    public void setUser(Zlecenie user) {
        this.user = user;
    }

    public Magazyn getBook() {
        return book;
    }

    public void setBook(Magazyn book) {
        this.book = book;
    }



}
