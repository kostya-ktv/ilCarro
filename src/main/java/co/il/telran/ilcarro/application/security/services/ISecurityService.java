package application.security.services;

import java.util.List;
import java.util.Set;

import application.security.dto.AccountDto;
import application.security.entities.Account;

public interface ISecurityService {

	AccountDto addUser(String login, String password);

	AccountDto addAccount(String login, String password, String role);

	List<AccountDto> getAllAccounts();
	
	AccountDto removeAccount(String login);

}