package co.il.telran.ilcarro.application.entities;


import co.il.telran.ilcarro.application.security.entities.Account;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

    @OneToOne(mappedBy = "user")
    private Account account;

    private String firstName;
    private String lastName;

    @Email
    @Column(unique = true)
    private String email;

    private Date birthday;
    private String about;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Comment> comments = new HashSet<>();

    private Set<Car> myCars;
    private Set<Car> rentCars;


}
