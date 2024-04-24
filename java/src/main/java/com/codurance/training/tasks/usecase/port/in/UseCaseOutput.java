package com.codurance.training.tasks.usecase.port.in;

public interface UseCaseOutput {
    static UseCaseOutput ofNull() {
        return new UseCaseOutput.NullOutput();
    }

    final class NullOutput implements UseCaseOutput {
        public NullOutput() {
        }
    }
}
