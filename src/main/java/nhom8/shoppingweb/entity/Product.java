package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "productdb")
@Table(name = "productdb")
@Data
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NAME;
    private long PRICE;
    private int PRODUCER_ID;
    private int STOCK_NUMBER;
    private String DESCRIPTION;
    private String IMAGE;
}