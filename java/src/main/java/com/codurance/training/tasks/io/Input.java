package com.codurance.training.tasks.io;

import java.io.BufferedReader;
import java.io.IOException;

public class Input {
    private final BufferedReader in;

    public Input(BufferedReader reader) {
        this.in = reader;
    }

    public String readLine() {
        try {
            return in.readLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
