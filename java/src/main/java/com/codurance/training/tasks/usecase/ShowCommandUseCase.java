package com.codurance.training.tasks.usecase;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.ToDoList;

import java.util.List;
import java.util.Map;

public class ShowCommandUseCase implements CommandUseCase {
    @Override
    public String execute(String commandLine) {
        Map<String, List<Task>> tasks = ToDoList.getInstance().getTasks();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            result.append(project.getKey()).append(System.lineSeparator());
            for (Task task : project.getValue()) {
                String msg = String.format("    [%c] %s: %s%n", (task.isDone() ? 'x' : ' '), task.getId().toString(), task.getDescription());
                result.append(msg);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
