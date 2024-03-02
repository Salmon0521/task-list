package com.codurance.training.tasks;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class TaskList {
    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();

    public Map<String, List<Task>> getTasks() {
        return tasks;
    }
}
