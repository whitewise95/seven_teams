package com.nautical99diary.nautical99diary.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class UserRequestDto {
    private Long id;
    private String username;
    private String nickname;
    private String password;
    private String passwordCheck;
}

