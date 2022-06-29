package pl.tomaszewski.demo.user;
import javax.persistence.*;
import java.util.UUID;

@Entity
public class User {

    @Id
    private UUID id;

}
