package com.nxtwave.todolist.services;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nxtwave.todolist.entities.Todo;
import com.nxtwave.todolist.repo.TodoRepository;

@Service
public class TodoService {

	private TodoRepository todoRepository;

	public TodoService(TodoRepository todoRepository) {
		this.todoRepository = todoRepository;
	}

	// API 1
	public List<Todo> getallTodos() {
		return todoRepository.findAll();
	}

	// API 2
	public Todo createTodo(Todo todo) {

		return todoRepository.save(todo);
	}

	// API 3
	public Todo getTodoById(int id) {
		Todo todo = todoRepository.findById(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Todo not found"));
		return todo;
	}

	// API 4
	public Todo updateTodo(int id, Todo todo1) {

		Todo todo = getTodoById(id);
		todo.setStatus(todo1.getStatus());
		todo.setPriority(todo1.getPriority());

		return todoRepository.save(todo);
	}

	// API 5
	public void deleteTodoById(int id) {
		todoRepository.deleteById(id);
	}

}
