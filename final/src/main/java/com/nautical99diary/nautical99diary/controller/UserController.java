package com.nautical99diary.nautical99diary.controller;

import com.nautical99diary.nautical99diary.dto.UserRequestDto;
import com.nautical99diary.nautical99diary.repository.UserRepository;
import com.nautical99diary.nautical99diary.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @PostMapping("/user/signup")
    public boolean saveUser(@RequestBody UserRequestDto userRequestDto) {
        return userService.saveUser(userRequestDto);
    }

    @GetMapping("/user/nicknameCheck/{nickname}")
    public boolean checkNickname(@PathVariable String nickname) {
        return userService.checkNickname(nickname);
    }

    @GetMapping("/user/idCheck/{username}")
    public boolean userNameCheck(@PathVariable String username) {
        return userService.userNameCheck(username);
    }
}
