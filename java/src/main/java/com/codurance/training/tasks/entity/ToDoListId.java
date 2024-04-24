package com.codurance.training.tasks.entity;

import tw.teddysoft.ezddd.core.entity.ValueObject;

public record ToDoListId(String id) implements ValueObject {
    public static ToDoListId of(String id) {
        return new ToDoListId(id);
    }
}
