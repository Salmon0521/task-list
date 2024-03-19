package com.codurance.training.tasks.io;

import java.io.PrintWriter;

public class Output {
    private final PrintWriter out;

    public Output(PrintWriter writer) {
        this.out = writer;
    }

    public void prompt() {
        out.print("> ");
        out.flush();
    }

    public void print(String message) {
        out.print(message);
    }
}
