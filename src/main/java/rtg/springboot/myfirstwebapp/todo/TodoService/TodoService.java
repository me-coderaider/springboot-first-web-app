package rtg.springboot.myfirstwebapp.todo.TodoService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import rtg.springboot.myfirstwebapp.todo.Todo.Todo;

@Service
public class TodoService {
	private static List<Todo> todos=new ArrayList<Todo>();

	static {
		todos.add(new Todo(1,"coderaider","Learn SpringBoot", LocalDate.now().plusMonths(4), false));
		todos.add(new Todo(2,"coderaider","Learn DesignPatterns", LocalDate.now().plusMonths(5), false));
		todos.add(new Todo(3,"coderaider","Learn Full Stack Development", LocalDate.now().plusMonths(6), false));
	}
	
	public List<Todo> findByUsername(String username){
		return todos;
	}
}
