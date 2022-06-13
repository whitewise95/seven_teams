package com.nautical99diary.nautical99diary.repository;

import com.nautical99diary.nautical99diary.domain.Todo;
import com.nautical99diary.nautical99diary.dto.TodoRequestDto;
import com.nautical99diary.nautical99diary.dto.UpdateDto;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class TodoRepositoryEM {

    @PersistenceContext
    private EntityManager em;

    public Todo findOne(Long id){
        Todo todo =  em.find(Todo.class, id);

        return todo;
    }


    public UpdateDto.TodoUpdate updateTodo(UpdateDto.TodoUpdate requestDto) {
        Todo todo = findOne(requestDto.getId());
        if(todo != null){
            todo.setTodo(requestDto.getTodo());
        } else {
            throw new IllegalArgumentException("해당 아이디가 없습니다.");
        }

        em.flush();

        return UpdateDto.TodoUpdate.builder()
                .id(todo.getId())
                .todo(todo.getTodo())
                .build();
    }

    public UpdateDto.CompletionUpdate updateComplete(UpdateDto.CompletionUpdate requestDto) {
        Todo todo = findOne(requestDto.getId());
        if(todo != null){
            todo.setCheckComplete(requestDto.isCheckComplete());
        } else {
            throw new IllegalArgumentException("해당 아이디가 없습니다.");
        }

        em.flush();

        return UpdateDto.CompletionUpdate.builder()
                .id(todo.getId())
                .checkComplete(todo.isCheckComplete())
                .build();
    }

    public void deleteTodo(Long id){
        Todo todo = findOne(id);
        if(todo != null){
            em.createQuery("delete from Todo t where t.id=:id")
                    .setParameter("id", id).executeUpdate();
        } else {
            throw new IllegalArgumentException("해당 아이디가 없습니다.");
        }
    }

}
