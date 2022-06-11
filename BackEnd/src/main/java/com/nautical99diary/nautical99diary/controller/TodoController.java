package com.nautical99diary.nautical99diary.controller;

import com.nautical99diary.nautical99diary.domain.Todo;
import com.nautical99diary.nautical99diary.dto.*;
import com.nautical99diary.nautical99diary.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/{goalDay}")
    public List<Todo> getTodo(@PathVariable String goalDay) {
        return todoService.getTodo(goalDay);
    }

    @PostMapping("/todo/{goalDay}")
    public Todo createTodo(@PathVariable String goalDay, @RequestBody TodoRequestDto todoRequestDto) {
        return todoService.createTodo(goalDay, todoRequestDto);
    }

    /**
     * updateTodo: todo 내용 업데이트
     *
     * @param id
     * @param todoUpdate
     * @return UpdateDto.TodoUpdate
     */
    @PostMapping("/todo/{goalDay}/{id}")
    public UpdateDto.TodoUpdate updateTodo
    (@PathVariable Long id, @RequestBody UpdateDto.TodoUpdate todoUpdate) {
        todoUpdate.setId(id);
        return todoService.updateTodo(todoUpdate);
    }

    /**
     * updateComplete: 완료 여부 업데이트
     *
     * @param id
     * @return UpdateDto.CompletionUpdate
     */
    @PutMapping("/todo/{goalDay}/{id}")
    public UpdateDto.CompletionUpdate updateComplete
    (@PathVariable Long id, @RequestBody UpdateDto.CompletionUpdate completionUpdate) {
        completionUpdate.setId(id);
        return todoService.updateComplete(completionUpdate);
    }

    @DeleteMapping("/todo/{goalDay}/{id}")
    public void deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
    }
}
