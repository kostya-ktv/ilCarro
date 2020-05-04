package co.il.telran.ilcarro.application.security.repositories;

import co.il.telran.ilcarro.application.security.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
