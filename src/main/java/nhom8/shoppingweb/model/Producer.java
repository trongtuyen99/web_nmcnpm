package nhom8.shoppingweb.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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