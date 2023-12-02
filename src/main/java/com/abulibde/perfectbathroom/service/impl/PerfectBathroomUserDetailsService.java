package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class PerfectBathroomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PerfectBathroomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(this::map)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User " + username + " is not found"));

    }

    private UserDetails map(UserEntity userEntity) {

        UserDetails userDetails = User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(List.of())//TODO:-------- add roles
                .build();

        return userDetails;
    }
}
