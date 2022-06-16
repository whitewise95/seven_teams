package com.nautical99diary.nautical99diary.service;

import com.nautical99diary.nautical99diary.domain.User;
import com.nautical99diary.nautical99diary.dto.UserRequestDto;
import com.nautical99diary.nautical99diary.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public boolean saveUser(UserRequestDto userRequestDto) {
        signUpValid(userRequestDto);
        return userRepository.findById(
                userRepository.save(
                        new User(
                                userRequestDto,
                                bCryptPasswordEncoder
                        )
                ).getId()
        ).isPresent();
    }

    @Transactional
    public boolean userNameCheck(String username) {
        return !(userRepository.findByUsername(username).isPresent());
    }

    @Transactional
    public boolean checkNickname(String nickname) {
        if (userRepository.findByNickname(nickname).size() != 0) {
            return false;
        } else {
            return true;
        }
    }

    public void signUpValid(UserRequestDto userRequestDto) {
        if (!userRequestDto.getPassword().equals(userRequestDto.getPasswordCheck())) {
            throw new IllegalArgumentException("비밀번호와 재확인 비밀번호가 맞지 않습니다.");
        }
        if (!userNameCheck(userRequestDto.getUsername())) {
            throw new IllegalArgumentException("userName이 중복됩니다.");
        }
        if (!checkNickname(userRequestDto.getNickname())) {
            throw new IllegalArgumentException("nickName이 중복됩니다.");
        }
    }
}
