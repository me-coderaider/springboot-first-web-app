package rtg.springboot.myfirstwebapp.loginAuthenticationService;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {
	
	public boolean authenticate(String username, String password) {
		
		boolean isValidUsername = username.equalsIgnoreCase("coderaider");
		boolean isValidPassword = password.equalsIgnoreCase("dummy123");
		 
		return isValidUsername && isValidPassword;
	}
}
