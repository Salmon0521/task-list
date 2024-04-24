package com.codurance.training.tasks.usecase.port.in;

public interface UseCaseInput {
    static UseCaseInput.NullInput ofNull() {
        return new UseCaseInput.NullInput();
    }

    final class NullInput implements UseCaseInput {
        public NullInput() {
        }
    }
}
