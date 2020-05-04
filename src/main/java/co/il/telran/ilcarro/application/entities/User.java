package co.il.telran.ilcarro.application.entities;


import co.il.telran.ilcarro.application.security.entities.Account;
import co.il.telran.ilcarro.application.security.entities.Role;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
    private String email;
    private Date birthday;
    private String about;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<Comment> comments = new ArrayList<>();

    private List<Car> myCars;
    private List<Car> rentCars;


}
