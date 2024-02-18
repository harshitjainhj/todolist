package com.nxtwave.todolist.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nxtwave.todolist.entities.Todo;

public interface TodoRepository extends JpaRepository<Todo, Integer>{

}
