package com.example.miniproject.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.miniproject.model.ToDoList;
import com.example.miniproject.request.UpsertTodo;

@Repository
public class ToDoListRepository {
    private List<ToDoList> toDoList = new ArrayList<ToDoList>();
    private int id = 0;

    public List<ToDoList> getToDoList() {
        return toDoList;
    }

    public ToDoList addToDo(UpsertTodo request) {
        ToDoList aTodo = new ToDoList(id++, request.getTitle(), false);
        toDoList.add(aTodo);
        return aTodo;
    }
}
