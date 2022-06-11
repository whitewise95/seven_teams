package com.nautical99diary.nautical99diary.service;

import com.nautical99diary.nautical99diary.domain.Todo;
import com.nautical99diary.nautical99diary.dto.*;
import com.nautical99diary.nautical99diary.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoRepositoryEM repositoryEM;
    //private final TodoRepository todoRepository;

    public List<Todo> getTodo(String day) {
        return todoRepository.findAllByGoalDay(day);
    }

    public Todo createTodo(String day, TodoRequestDto todoRequestDto) {
        Todo todo = new Todo(day, todoRequestDto);
        todoRepository.save(todo);
        return todo;
    }

    public UpdateDto.TodoUpdate updateTodo(UpdateDto.TodoUpdate requestDto) {
        return repositoryEM.updateTodo(requestDto);
    }

    public UpdateDto.CompletionUpdate updateComplete(UpdateDto.CompletionUpdate requestDto) {
        return repositoryEM.updateComplete(requestDto);
    }

    public void deleteTodo(Long id) {
        repositoryEM.deleteTodo(id);
    }
}
