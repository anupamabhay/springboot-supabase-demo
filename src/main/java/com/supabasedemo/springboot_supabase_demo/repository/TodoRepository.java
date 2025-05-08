package com.supabasedemo.springboot_supabase_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.supabasedemo.springboot_supabase_demo.model.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Integer> {
    // Custom query methods can be defined here if needed
    
}
