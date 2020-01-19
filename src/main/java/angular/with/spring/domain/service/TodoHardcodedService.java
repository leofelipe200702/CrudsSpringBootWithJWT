package angular.with.spring.domain.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import angular.with.spring.domain.entity.Todo;

@Service
public class TodoHardcodedService {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long idCounter = 0;

	static {

		todos.add(new Todo(++idCounter, "Leo", "Learn Angular", new Date(), false));
		todos.add(new Todo(++idCounter, "Leo", "Learn React", new Date(), false));
		todos.add(new Todo(++idCounter, "Leo", "Learn Node", new Date(), false));
		todos.add(new Todo(++idCounter, "Leo", "Learn Spring", new Date(), false));

	}

	public List<Todo> findAll() {
		return todos;
	}

	public Todo removeById(long id) {
		Todo todo = findById(id);
		if (todo != null) {
			todos.remove(todo);
			return todo;
		}
		return null;
	}
	
	public Todo save(Todo todo) {
		if(todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++idCounter);
			todos.add(todo);
			
		}else {
			removeById(todo.getId());
			todos.add(todo);
		}
		
		return todo;
	}

	public Todo findById(long id) {
		for (Todo todo : todos) {
			if (todo.getId() == id) {
				return todo;
			}
		}
		return null;
	}

}
