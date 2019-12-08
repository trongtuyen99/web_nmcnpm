package nhom8.shoppingweb.entity;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;

@Entity(name = "userdb")
@Table(name = "userdb")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ID;
    private String FULLNAME;
    private String PHONE;
    private String EMAIL;
    private String USERNAME;
    private String ROLE;
    private String PASSWORD;
    private String CPASSWORD;
}