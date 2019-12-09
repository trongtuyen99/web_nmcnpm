package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "orderdb")
@Table(name = "orderdb")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int PRODUCT_ID;
    private java.util.Date CREATED_TIME;
    private String ADDRESS;
    private long PRICE;
    private int QUANTITY;
}