package application.security.entities;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
@Data
@Document(collection="account")

public class Account {
	
	@Id
	private String login;
	private String password;
	
	private Set<String> roles = new HashSet<>();
	
	public Account(String login, String password, String role) {
		super();
		this.login = login;
		this.password = password;
		this.roles.add(role);

	}
}
