package com.nxtwave.todolist.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.nxtwave.todolist.entities.Todo;
import com.nxtwave.todolist.services.TodoService;

@RestController
@RequestMapping("/todos")
public class TodoController {

	private TodoService todoService;

	public TodoController(TodoService todoService) {
		this.todoService = todoService;
	}

	// API 1 GET request
	@GetMapping
	public List<Todo> getallTodos() {
		return todoService.getallTodos();
	}

	// API 2 POST request
	@PostMapping
	public Todo createTodo(@RequestBody Todo todo) {
		System.out.println(todo);
		return todoService.createTodo(todo);
	}

	// API 3 GET request
	@GetMapping("/{id}")
	public Todo getTodoById(@PathVariable int id) {
		return todoService.getTodoById(id);
	}

	// API 4 PUT request
	@PutMapping("/{id}")
	public Todo updateTodo(@RequestBody Todo todo, @PathVariable int id) {
		return todoService.updateTodo(id, todo);
	}

	// API 5 DELETE request
	@DeleteMapping("/{id}")
	public void deleteTodo(@PathVariable int id) {
		todoService.deleteTodoById(id);
	}

}
