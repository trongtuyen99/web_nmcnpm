package nhom8.shoppingweb.model;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "contactdb")
@Table(name = "contactdb")
@Data //lombok
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String NAME;
    private String EMAIL;
    private String MESSAGE;
}