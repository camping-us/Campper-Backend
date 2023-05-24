package com.campper.global.security;

import com.campper.domain.users.entity.User;
import com.campper.domain.users.repository.UserRepository;
import com.campper.global.common.error.ErrorCode;
import com.campper.global.common.error.exception.UnauthorizedException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;

@Slf4j
@Service
@RequiredArgsConstructor
public class CustomUserDetailServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByAuthKey(username)
                .orElseThrow(() -> new UnauthorizedException(ErrorCode.INVALID_TOKEN));
        return new CustomUserDetails(user,Collections.singleton(new SimpleGrantedAuthority(user.getRole().getViewName())));
    }
}