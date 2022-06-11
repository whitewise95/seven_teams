package com.nautical99diary.nautical99diary.config;

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
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder encodePwd(){
        return new BCryptPasswordEncoder();
    }

    public static class SecurityConfiguration{

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http.csrf().disable();
            http
                    .authorizeHttpRequests((authz) -> {
                                try {
                                    authz
                                            .antMatchers("/user/signup").permitAll()
                                            .antMatchers("/user/idCheck/**").permitAll()
                                            .antMatchers("/user/nicknameCheck/**").permitAll()
                                            .antMatchers("/loginForm").permitAll()
                                            .anyRequest().authenticated()
                                        .and()
                                            .formLogin()
                                            .loginPage("/loginForm")
                                            .loginProcessingUrl("/user/login")
                                            .defaultSuccessUrl("/")
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

//        @Bean
//        public void staticConfigure(WebSecurity web) throws Exception{
//            web.ignoring().antMatchers("/resources/**");
//        }

    }
}
