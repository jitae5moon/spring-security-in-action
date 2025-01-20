package com.example.chapter02.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("admin")
                .password("1234")
                .authorities("ADMIN")
                .build();
        userDetailsService.createUser(user);

        /*
         * 그대로 실행할 시 콘솔에 자동생성된 암호 출력 안 됨.
         * 다음 두가지 이유로 접근 불가
         * 사용자 없음.
         * PasswordEncoder 없음.
         */
        return userDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();

        // 모든 요청에 인증 필요
        http.authorizeRequests()
                .anyRequest().authenticated(); // vs permitAll()
    }

    /*
     * UserDetailsService, PasswordEncoder를 빈으로 정의하는 대신 메서드로 정의
     */

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        var userDetailsService = new InMemoryUserDetailsManager();

        var user = User.withUsername("Moon")
                .password("1234")
                .authorities("ADMIN")
                .build();

        userDetailsService.createUser(user);

        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }
}
