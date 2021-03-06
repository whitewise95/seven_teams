package com.nautical99diary.nautical99diary.domain;

import com.nautical99diary.nautical99diary.domain.resultType.Timestamped;
import com.nautical99diary.nautical99diary.dto.UserRequestDto;
import lombok.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false, unique = true)
    private String nickname;

    public User(UserRequestDto userRequestDto, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.username = userRequestDto.getUsername();
        this.nickname = userRequestDto.getNickname();
        this.password = bCryptPasswordEncoder.encode(userRequestDto.getPassword());
    }
}
