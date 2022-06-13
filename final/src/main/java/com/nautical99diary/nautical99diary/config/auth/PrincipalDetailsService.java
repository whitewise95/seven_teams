package com.nautical99diary.nautical99diary.config.auth;

import com.nautical99diary.nautical99diary.domain.User;
import com.nautical99diary.nautical99diary.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class PrincipalDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public PrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userEntity = userRepository.findByUsername(username).orElseThrow(
                () -> new UsernameNotFoundException("해당 유저가 없습니다."));

        return new PrincipalDetails(userEntity);
    }
}
