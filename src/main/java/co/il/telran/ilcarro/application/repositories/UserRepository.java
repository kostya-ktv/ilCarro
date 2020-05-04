package co.il.telran.ilcarro.application.repositories;

import co.il.telran.ilcarro.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
