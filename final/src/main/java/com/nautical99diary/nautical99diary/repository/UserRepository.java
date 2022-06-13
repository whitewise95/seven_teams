package com.nautical99diary.nautical99diary.repository;

import com.nautical99diary.nautical99diary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNickname(String nickname);

    Optional<User> findByUsername(String username);
}
