package application.security.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import application.security.dto.AccountDto;
import application.security.entities.Account;

@Service
public class DtoService {
	
	public AccountDto accountDto(Account account) {
		return new AccountDto(account.getLogin(), account.getRoles());
	}
	
	public List<AccountDto> accountDtoList(List<Account> accountList) {
		return accountList.stream().map(account -> accountDto(account)).collect(Collectors.toList());
	}
}
