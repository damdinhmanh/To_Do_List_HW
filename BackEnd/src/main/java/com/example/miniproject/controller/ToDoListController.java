package com.example.miniproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.miniproject.model.ToDoList;
import com.example.miniproject.request.UpsertTodo;
import com.example.miniproject.service.ToDoListService;

@RestController
@RequestMapping("/api/v1")
public class ToDoListController {

    @Autowired
    ToDoListService toDoListService;

    @GetMapping("todos")
    public List<ToDoList> getAllToDoList() {
        return toDoListService.getToDoList();
    }

    @PostMapping("todos")
    public ToDoList createTodo(@RequestBody UpsertTodo request) {
        return toDoListService.addToDo(request);
    }

    @PutMapping("todos/{id}")
    public ToDoList updateTodo(@PathVariable int id, @RequestBody UpsertTodo request) {
        return toDoListService.updateTodo(id, request);
    }

    @DeleteMapping("todos/{id}")
    public void deleteTodo(@PathVariable int id) {
        toDoListService.deleteTodo(id);
    }
}
