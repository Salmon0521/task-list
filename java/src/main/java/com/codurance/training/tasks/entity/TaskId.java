package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.ValueObject;

public record TaskId(String value) implements ValueObject {
    public static TaskId of(long id) {
        return new TaskId(String.valueOf(id));
    }

    @Override
    public String toString() {
        return value;
    }
}
