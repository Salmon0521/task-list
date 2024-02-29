package com.codurance.training.tasks.operator;

import com.codurance.training.tasks.Task;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

public interface Operator {

    void execute(String command, Map<String, List<Task>> tasks, PrintWriter out);
}
