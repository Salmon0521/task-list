package com.codurance.training.tasks.usecase.command;

import com.codurance.training.tasks.entity.Task;
import com.codurance.training.tasks.entity.TaskList;

import java.util.List;
import java.util.Map;

public class ShowCommand implements Command {
    @Override
    public String execute() {
        Map<String, List<Task>> tasks = TaskList.getInstance().getTasks();
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, List<Task>> project : tasks.entrySet()) {
            result.append(project.getKey()).append(System.lineSeparator());
            for (Task task : project.getValue()) {
                String msg = String.format("    [%c] %d: %s%n", (task.isDone() ? 'x' : ' '), task.getId(), task.getDescription());
                result.append(msg);
            }
            result.append(System.lineSeparator());
        }
        return result.toString();
    }
}
