package com.codurance.training.tasks.entity;

public record TaskId(long id) {
    public static TaskId of(long id) {
        return new TaskId(id);
    }

    @Override
    public String toString() {
        return String.valueOf(id);
    }
}
