package com.nautical99diary.nautical99diary.repository;

import com.nautical99diary.nautical99diary.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Long> {
   List<User> findByNickname(String nickname);

}
