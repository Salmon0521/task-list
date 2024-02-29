package com.codurance.training.tasks;

public class Utiliy {
    private static long lastId = 0;

    public static long nextId() {
        return ++lastId;
    }
}
