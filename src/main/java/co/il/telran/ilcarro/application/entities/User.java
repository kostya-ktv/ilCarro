package co.il.telran.ilcarro.application.entities;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User extends BaseEntity{

    private String userName;
    private String firstName;
    private String lastName;
    private Date birthday;
    private String about;

    private List<Comment> comments;

    private List<Car> myCars;
    private List<Car> rentCars;

    private List<Role> roles;

}
