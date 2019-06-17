package entities;

import javax.persistence.*;

@Entity
@Table(name="Orders")
public class tempSerwis {
    private  int id;
    private  int orderId;
    private  int storageId;

    public tempSerwis() {    }

    public tempSerwis(int id, int orderId, int storageId) {
        this.id = id;
        this.orderId = orderId;
        this.storageId = storageId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true)
    public int getId() {        return id;    }
    public void setId(int id) {        this.id = id;    }

    @Column(name = "orderId")
    public int getOrderId() {        return orderId;    }
    public void setOrderId(int orderId) {        this.orderId = orderId;    }

    @Column(name = "storageId")
    public int getStorageId() {        return storageId;    }
    public void setStorageId(int storageId) {        this.storageId = storageId;    }
}
