package com.codurance.training.tasks.usecase.port;

import com.codurance.training.tasks.usecase.port.in.UseCaseInput;
import com.codurance.training.tasks.usecase.port.in.todolist.show.ShowOutput;
import com.codurance.training.tasks.usecase.port.out.UseCaseOutput;

public interface UseCase<I extends UseCaseInput, O extends UseCaseOutput>  {
    ShowOutput execute(I input);
}
