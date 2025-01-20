package com.example.chapter02.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;

/*
 * UserDetailsService, PasswordEncoder가 필요없도록 재정의
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName(); // Principal의 getName()을 Authentication에서 상속받음.
        String password = authentication.getCredentials().toString();

        // UserDetailsService, PasswordEncoder 대체
        if ("admin".equals(username) && "1234".equals(password)) {
            return new UsernamePasswordAuthenticationToken(username, password, List.of());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error in authentication.");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        // Authentication 형식의 구현 추가
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }

}
