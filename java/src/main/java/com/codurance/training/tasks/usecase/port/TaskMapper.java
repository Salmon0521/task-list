package com.codurance.training.tasks.usecase.port;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.usecase.port.in.todolist.show.TaskDto;

import java.util.List;

public class TaskMapper {
    public static TaskDto toDto(Task task) {
        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId().value());
        taskDto.setDescription(task.getDescription());
        taskDto.setDone(task.isDone());
        return taskDto;
    }

    public static List<TaskDto> toDto(List<Task> tasks) {
        return tasks.stream()
                .map(TaskMapper::toDto)
                .toList();
    }
}
