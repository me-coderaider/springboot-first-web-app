package rtg.springboot.myfirstwebapp.hello.SayHelloController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello() {
		return "Hello! What are you learning today?";
	}

	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>My First Web App</title>");
		sb.append("</head>");
		sb.append("<body> My first HTML page with body </body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/sayHello.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/welcome.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/login.jsp
	// /src/main/resources/META-INF/resources/WEB-INF/jsp/todos.jsp
	@RequestMapping("say-hello-jsp")
//	@ResponseBody -- not required as it'll just return "sayHello" as String but not pointing to the .jsp file
	public String sayHelloJsp() {
		return "sayHello";
	}
}
