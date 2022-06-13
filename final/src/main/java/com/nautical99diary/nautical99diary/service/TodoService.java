package com.nautical99diary.nautical99diary.service;

import com.nautical99diary.nautical99diary.config.auth.PrincipalDetails;
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
    private final TodoRepositoryEM repositoryJPQL;

    public List<Todo> getTodo(String day, PrincipalDetails userDetails) {
        Long userId = userDetails.getUser().getId();
        return todoRepository.findAllByGoalDayAndUserID(day,userId);
    }

    public Todo createTodo(String day, TodoRequestDto todoRequestDto, PrincipalDetails userDetails) {
        Todo todo = new Todo(day, todoRequestDto,userDetails);
        todoRepository.save(todo);
        return todo;
    }

    public UpdateDto.TodoUpdate updateTodo(UpdateDto.TodoUpdate requestDto) {
        return repositoryJPQL.updateTodo(requestDto);
    }

    public UpdateDto.CompletionUpdate updateComplete(UpdateDto.CompletionUpdate requestDto) {
        return repositoryJPQL.updateComplete(requestDto);
    }

    public void deleteTodo(Long id) {
        repositoryJPQL.deleteTodo(id);
    }
}
