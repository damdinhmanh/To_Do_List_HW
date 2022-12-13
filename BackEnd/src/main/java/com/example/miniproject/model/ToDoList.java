package com.example.miniproject.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ToDoList {
    private int id;
    private String title;
    private Boolean status;
}
