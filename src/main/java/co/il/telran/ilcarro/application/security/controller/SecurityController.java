package application.security.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.security.dto.AccountDto;
import application.security.dto.AuthPair;
import application.security.services.ISecurityService;

@RestController
@RequestMapping("/security")
@CrossOrigin
@Validated
public class SecurityController {
	
	@Autowired ISecurityService service;
	
	@PostMapping("/addUser") //create new account
	public AccountDto addUser(@RequestBody @Valid AuthPair authPair) {
		return service.addUser(authPair.getLogin(), authPair.getPassword());
	};

	@PostMapping("/addAccount")
	public AccountDto addAccount(@RequestBody AuthPair authPair, @RequestParam String role) {
		return service.addAccount(authPair.getLogin(), authPair.getPassword(), role);
	};
	
	@GetMapping("/getAllAccounts")
	public List<AccountDto> getAllAccounts(){
		return service.getAllAccounts();
	};

	@DeleteMapping("/removeAccount")
	public AccountDto removeAccount(String login) {
		return service.removeAccount(login);
	};

	@ExceptionHandler(value = { MethodArgumentNotValidException.class })
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<String> handleBodyException(MethodArgumentNotValidException exception) {
        System.out.println(exception.getBindingResult().getAllErrors());
        return exception.getBindingResult().getAllErrors().stream()
                            .map((e)-> e.getObjectName()+": "+e.getDefaultMessage())
                            .collect(Collectors.toList());
         
    }
     
    @ExceptionHandler(value = { ConstraintViolationException.class })
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    public List<String> handleParamException(ConstraintViolationException exception) {
        System.out.println("second");
        return exception.getConstraintViolations().stream()
                .map((e)-> e.getMessage()+": "+e.getInvalidValue())
                .collect(Collectors.toList());   
    }
}
