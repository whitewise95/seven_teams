package com.nautical99diary.nautical99diary.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@RequiredArgsConstructor
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    public static class SecurityConfiguration{

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable()
                    .authorizeHttpRequests((authz) -> {
                                try {
                                    authz
                                            .antMatchers("/").permitAll()
                                            .antMatchers("/h2-console/**").permitAll()
                                            .antMatchers("/user/signup").permitAll()
                                            .antMatchers("/user/idCheck/**").permitAll()
                                            .antMatchers("/user/nicknameCheck/**").permitAll()
                                            .anyRequest().authenticated()
                                        .and()
                                            .formLogin()
                                            .loginPage("/user/login")
                                            .loginProcessingUrl("/user/login")
                                            .defaultSuccessUrl("/")
                                            //.failureHandler(userLoginFailHandler)
                                            .permitAll()
                                        .and()
                                            .logout().permitAll();

                                } catch (Exception e) {
                                    throw new RuntimeException(e);
                                }
                            }
                    );

            return http.build();
        }
    }
}
