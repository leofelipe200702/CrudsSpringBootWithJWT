package angular.with.spring.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import angular.with.spring.domain.entity.Todo;
import angular.with.spring.domain.repository.TodoJpaRepository;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TodoController {

	@Autowired
	private TodoJpaRepository todoJpaRepository;
	
	@ApiOperation(value = "Retorna uma lista de tarefas pelo nome do Usuário")
	@GetMapping(value = "/users/{username}/todos",produces="application/json")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return this.todoJpaRepository.findByUsername(username);
	}
	
	@ApiOperation(value = "Retorna uma tarefa específica por Id pelo nome do Usuário")
	@GetMapping(value = "/users/{username}/todos/{id}",produces="application/json")
	public Todo getTodo(@PathVariable String username,@PathVariable long id) {
		return this.todoJpaRepository.findById(id).get();
	}
	
	@ApiOperation(value = "Apaga uma tarefa específica por Id pelo nome do Usuário")
	@DeleteMapping(value = "/users/{username}/todos/{id}",produces="application/json")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {
		todoJpaRepository.deleteById(id);
		return ResponseEntity.noContent().build();
	}
	
	@ApiOperation(value = "Altera uma tarefa específica por Id pelo nome do Usuário")
	@PutMapping(value = "/users/{username}/todos/{id}",produces="application/json")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,@RequestBody Todo todo) {
		Todo todoUpdated = todoJpaRepository.save(todo);
		return new ResponseEntity<Todo>(todoUpdated,HttpStatus.OK);
	}
	
	@ApiOperation(value = "Inclui uma tarefa para o Usuário")
	@PostMapping(value = "/users/{username}/todos",produces="application/json")
	public ResponseEntity<Void> createTodo(@PathVariable String username,@RequestBody Todo todo) {
		todo.setUsername(username);
		
		Todo todoCreated =  this.todoJpaRepository.save(todo);	
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todoCreated.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}	

}
