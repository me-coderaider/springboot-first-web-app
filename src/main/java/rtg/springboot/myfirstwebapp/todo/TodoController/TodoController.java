package rtg.springboot.myfirstwebapp.todo.TodoController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import rtg.springboot.myfirstwebapp.todo.Todo.Todo;
import rtg.springboot.myfirstwebapp.todo.TodoService.TodoService;

@Controller
@SessionAttributes("name")
public class TodoController {
	
	private TodoService todoService;
	
	@Autowired
	public TodoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	@RequestMapping(value="list-todos", method=RequestMethod.GET)
	public String listAllTodos(ModelMap map) {
		List<Todo> todos = todoService.findByUsername("Pankaj");
//		map.put("todos", todos);
		map.addAttribute("todos",todos);
		return "listTodos";
	}
}
