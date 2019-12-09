package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "contactdb")
@Table(name = "contactdb")
@Data
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NAME;
    private String EMAIL;
    private String MESSAGE;
}