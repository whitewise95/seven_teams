package com.nautical99diary.nautical99diary.controller;


import com.nautical99diary.nautical99diary.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class UserController {
    private final UserRepository userRepository;


    @GetMapping("/user/nicknameCheck/{nickname}")
    public boolean checkNickname(@PathVariable String nickname){
        if(userRepository.findByNickname(nickname).size() != 0){
            return false;
        }else{
            return true;
        }
    }
}
