package co.il.telran.ilcarro.application.security.entities;

import co.il.telran.ilcarro.application.entities.BaseEntity;
import co.il.telran.ilcarro.application.entities.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter

@Entity
@Table(name="role")

public class Account extends BaseEntity {

    @Column(unique = true)
    private String login;

    private String password;

    @OneToOne
    private User user;

    @JsonIgnore
    private Set<Role> roles = new HashSet<>();
}
