package com.supabasedemo.springboot_supabase_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.supabasedemo.springboot_supabase_demo.model.Todo;
import com.supabasedemo.springboot_supabase_demo.repository.TodoRepository;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/todos")
public class TodoController {
    private final TodoRepository repo;
    public TodoController(TodoRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Todo> list() {
        return repo.findAll();
    }

    @PostMapping
    public Todo create(@RequestBody Todo todo) {
        return repo.save(todo);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Todo> update(@PathVariable Integer id, @RequestBody Todo todo) {
        return repo.findById(id)
        .map(existingTodo -> {
            if (todo.getTask() != null) {
                existingTodo.setTask(todo.getTask());
            }
            if (todo.getDone() != null) {
                existingTodo.setDone(todo.getDone());
            }
            return ResponseEntity.ok(repo.save(existingTodo));
        })
        .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Integer id) {
        if (!repo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repo.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
}
