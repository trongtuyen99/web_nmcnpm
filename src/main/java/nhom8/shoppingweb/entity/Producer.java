package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "producerdb")
@Table(name = "producerdb")
@Data
public class Producer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private String NAME;
    private String WEBSITE;
}