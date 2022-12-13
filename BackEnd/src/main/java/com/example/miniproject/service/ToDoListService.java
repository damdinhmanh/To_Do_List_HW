package com.example.miniproject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.miniproject.model.ToDoList;
import com.example.miniproject.repository.ToDoListRepository;
import com.example.miniproject.request.UpsertTodo;

@Service
public class ToDoListService {
    
    @Autowired
    ToDoListRepository toDoListRepository;

    public List<ToDoList> getToDoList() {
        return toDoListRepository.getToDoList();
    }

    public ToDoList addToDo(UpsertTodo request) {
        return toDoListRepository.addToDo(request);
    }

    public ToDoList updateTodo(int id, UpsertTodo request) {
        List<ToDoList> allList = getToDoList();
        Optional<ToDoList> aTodo = allList.stream().
                                            filter(td -> td.getId() == id)
                                            .findFirst();
        if (aTodo.isPresent()) {
            ToDoList toDoList = aTodo.get();
            toDoList.setTitle(request.getTitle());
            toDoList.setStatus(request.getStatus());
            return toDoList;
        }
        return null;
    }

    public void deleteTodo(int id) {
        List<ToDoList> allList = getToDoList();
        Optional<ToDoList> aTodo = allList.stream().
                                            filter(td -> td.getId() == id)
                                            .findFirst();
        if (aTodo.isPresent()) {
            ToDoList toDoList = aTodo.get();
            allList.remove(toDoList);
        }
    }
}
