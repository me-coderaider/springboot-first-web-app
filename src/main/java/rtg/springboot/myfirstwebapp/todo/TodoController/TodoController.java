package rtg.springboot.myfirstwebapp.todo.TodoController;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;
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
	public String listAllTodos(ModelMap model) {
		List<Todo> todos = todoService.findByUsername("Pankaj");
//		model.put("todos", todos);
		model.addAttribute("todos",todos);
		return "listTodos";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTodoPage(ModelMap model) {
		String username=(String)model.get("username");
		Todo todo=new Todo(0, username, "", LocalDate.now().plusMonths(2),false);
		model.put("todo", todo);
		return "todo";
	}
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username=(String)model.get("username");
		todoService.addTodo(username, todo.getDescription(), LocalDate.now().plusMonths(1), false);
 		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		// delete todo with specific ID
		todoService.deleteById(id);
		return "redirect:list-todos";
	}
}
