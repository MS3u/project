package entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "tempserwis")
public class TempserwisEntity {
    private int id;
    private int orderId;
    private int storageId;

    @Id
    @Column(name = "Id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "orderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "storageId")
    public int getStorageId() {
        return storageId;
    }

    public void setStorageId(int storageId) {
        this.storageId = storageId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TempserwisEntity that = (TempserwisEntity) o;
        return id == that.id &&
                orderId == that.orderId &&
                storageId == that.storageId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, storageId);
    }
}
