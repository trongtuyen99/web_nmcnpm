package nhom8.shoppingweb.model;

import javax.persistence.*;

import lombok.Data;

@Entity(name = "userdb")
@Table(name = "userdb")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String FIRSTNAME;
    private String LASTNAME;
    private String EMAIL;
    private String USERNAME;
    private String PASSWORD;
    private String CPASSWORD;
}