package com.codurance.training.tasks.usecase.port;

import com.codurance.training.tasks.entity.ToDoList;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ToDoListDto;

public class ToDoListMapper {
    public static ToDoListDto toDto(ToDoList toDoList) {
        ToDoListDto toDoListDto = new ToDoListDto();
        toDoListDto.setId(toDoList.getId().value());
        toDoListDto.setProjectDtos(
                ProjectMapper.toDto(toDoList.getProjects()));

        return toDoListDto;
    }
}
