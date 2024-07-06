package rtg.springboot.myfirstwebapp.login.LoginController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import rtg.springboot.myfirstwebapp.loginAuthenticationService.AuthenticationService;

@Controller
public class LoginController {
	
	private AuthenticationService authenticationService;
	
	public LoginController(AuthenticationService authenticationService) {
		super();
		this.authenticationService = authenticationService;
	}

	@RequestMapping(value="login", method=RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		model.put("name",name);
		
		if(!authenticationService.authenticate(name, password)) {
			// as authentication failed. So we'll send some error message using MODEL
			model.put("errorMessage", "Invalid Credentails! Please try again");
			
			return "login";
		}
		return "welcome";
	}
}
