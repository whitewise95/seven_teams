package com.nautical99diary.nautical99diary.service;

import com.nautical99diary.nautical99diary.domain.User;
import com.nautical99diary.nautical99diary.dto.UserRequestDto;
import com.nautical99diary.nautical99diary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public boolean saveUser(UserRequestDto userRequestDto) {
        if (!userRequestDto.getPassword().equals(userRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호와 재확인 비밀번호가 맞지 않습니다.");
        }
        return userRepository.findById(userRepository.save(new User(userRequestDto)).getId()).isPresent();
    }

    @Transactional
    public boolean userNameCheck(String username) {
        return !(userRepository.findByUsername(username).isPresent());
    }
}
