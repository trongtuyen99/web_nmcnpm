package nhom8.shoppingweb.model;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "productdb")
@Table(name = "productdb")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NAME;
    private Long PRICE;
    private int PRODUCER_ID;
    private int STOCK_NUMBER;
    private String DESCRIPTION;
    private String IMAGE;
}