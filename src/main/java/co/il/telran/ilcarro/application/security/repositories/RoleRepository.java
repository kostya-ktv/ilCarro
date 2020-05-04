package co.il.telran.ilcarro.application.security.repositories;

import co.il.telran.ilcarro.application.security.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,String> {
}
