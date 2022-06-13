package com.nautical99diary.nautical99diary.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class UpdateDto {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class TodoUpdate {
        private long id;
        private String todo;

        @Builder
        public TodoUpdate(long id, String todo) {
            this.id = id;
            this.todo = todo;
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class CompletionUpdate {
        private long id;
        private boolean checkComplete;

        @Builder
        public CompletionUpdate(long id, boolean checkComplete) {
            this.id = id;
            this.checkComplete = checkComplete;
        }
    }

}
