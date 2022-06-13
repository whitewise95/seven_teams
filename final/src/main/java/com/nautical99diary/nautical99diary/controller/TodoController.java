package com.nautical99diary.nautical99diary.controller;

import com.nautical99diary.nautical99diary.config.auth.PrincipalDetails;
import com.nautical99diary.nautical99diary.domain.Todo;
import com.nautical99diary.nautical99diary.dto.*;
import com.nautical99diary.nautical99diary.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class TodoController {

    private final TodoService todoService;

    @GetMapping("/todo/{goalDay}")
    public List<Todo> getTodo(@PathVariable String goalDay,@AuthenticationPrincipal PrincipalDetails userDetails) {
        return todoService.getTodo(goalDay,userDetails);
    }

    @PostMapping("/todo/{goalDay}")
    public Todo createTodo(@PathVariable String goalDay, @RequestBody TodoRequestDto todoRequestDto,@AuthenticationPrincipal PrincipalDetails userDetails) {
        return todoService.createTodo(goalDay, todoRequestDto,userDetails);

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
     * @param id
     * @param completionUpdate
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