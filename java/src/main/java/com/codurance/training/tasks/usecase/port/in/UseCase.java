package com.codurance.training.tasks.usecase.port.in;

public interface UseCase<I extends UseCaseInput, O extends UseCaseOutput>  {
    O execute(I input);
}
