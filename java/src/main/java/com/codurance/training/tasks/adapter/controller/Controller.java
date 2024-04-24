package com.codurance.training.tasks.adapter.controller;

import com.codurance.training.tasks.entity.ToDoList;

public interface Controller {
    String execute(ToDoList toDoList, String commandLine);
}
