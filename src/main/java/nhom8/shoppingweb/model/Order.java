package nhom8.shoppingweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity(name = "orderdb")
@Table(name = "orderdb")
@Data
public class Order implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int PRODUCT_ID;
    private Date CREATED_TIME;
    private String ADDRESS;
    private long PRICE;
    private int QUANTITY;
}