package application.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.security.services.ISecurityService;

@RestController
@RequestMapping("/jwt")
@CrossOrigin
public class JWTController {
	
	@Autowired AuthenticationManager authenticationManager;
	@Autowired JWTTokenUtil jwtTokenUtil;
	@Autowired UserDetailsService userDetailsService;
	@Autowired ISecurityService securityService;
	
	@PostMapping("/authenticate")
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JWTRequest authenticationRequest) throws Exception {
	
		authenticate(authenticationRequest.getLogin(), authenticationRequest.getPassword());
		String token = jwtTokenUtil.generateToken(authenticationRequest.getLogin());
		return ResponseEntity.ok(new JWTResponse(token));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (BadCredentialsException e) {
			throw new Exception("Wrong login-password pair", e);
		}
	}
	
	@ExceptionHandler(value = {Exception.class })
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleException(Exception exception) {
		return exception.getMessage();
		
    }
}
