package nhom8.shoppingweb.model;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "productdb")
@Table(name = "productdb")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NAME;
    private String PRICE;
    private int PRODUCER_ID;
    private int STOCK_NUMBER;
    private String DESCRIPTION;
    private String IMAGE;
}