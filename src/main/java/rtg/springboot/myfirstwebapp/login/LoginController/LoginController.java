package rtg.springboot.myfirstwebapp.login.LoginController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
	
	private Logger logger =LoggerFactory.getLogger(getClass());
	
	@RequestMapping("login")
	public String goToLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		logger.debug("Request Params is {}", name);
		logger.info("I want this to printed at info level");
		logger.warn("I want this to printed at warn level");
		return "login";
	}
}
