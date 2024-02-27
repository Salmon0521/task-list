package com.codurance.training.tasks;

import com.codurance.training.tasks.operator.Operator;
import com.codurance.training.tasks.operator.OperatorFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class TaskList implements Runnable {
    private static final String QUIT = "quit";

    private final Map<String, List<Task>> tasks = new LinkedHashMap<>();
    private final BufferedReader in;
    private final PrintWriter out;

    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        new TaskList(in, out).run();
    }

    public TaskList(BufferedReader reader, PrintWriter writer) {
        this.in = reader;
        this.out = writer;
    }

    public void run() {
        while (true) {
            out.print("> ");
            out.flush();
            String commandline;
            try {
                commandline = in.readLine();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            if (commandline.equals(QUIT)) {
                break;
            }
            Command command = new Command(commandline);
            OperatorFactory operatorFactory = new OperatorFactory();
            Operator operator = operatorFactory.createOperator(command.getCommand());
            operator.execute(commandline, tasks, out);
        }
    }

}
