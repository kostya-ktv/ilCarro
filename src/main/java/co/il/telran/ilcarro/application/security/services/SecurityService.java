package application.security.services;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import application.security.dto.AccountDto;
import application.security.entities.Account;
import application.security.repositories.AccountMongoRepository;

@Transactional
@Service
public class SecurityService implements ISecurityService {
	
	@Autowired AccountMongoRepository accountRepo;
	@Autowired DtoService dtoService;
	@Autowired PasswordEncoder encoder;

	private Account getAccount(String login) {
		Account account = accountRepo.findById(login).orElse(null);
		if (account == null)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Login "+login+" not found");
		return account;
	}

	@Override
	public AccountDto addUser(String login, String password) {
		if (accountRepo.existsById(login))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicated login "+login);
		Account account = new Account(login, encoder.encode(password), "ROLE_USER");
		accountRepo.save(account);
		return dtoService.accountDto(account);
	}
	
	@Override
	public AccountDto addAccount(String login, String password, String role) {
		
		if (accountRepo.existsById(login))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Duplicated login "+login);
		
		Account account = new Account(login, encoder.encode(password), "ROLE_"+role);
		accountRepo.save(account);
		return dtoService.accountDto(account);
	}
	
	
	@Override
	public List<AccountDto> getAllAccounts() {
		return dtoService.accountDtoList(accountRepo.findAll());
	}

	@Override
	public AccountDto removeAccount(String login) {
		Account account = getAccount(login);
		accountRepo.deleteById(login);
		return dtoService.accountDto(account);
	}
	
	
}
