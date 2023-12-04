package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.model.entity.UserRoleEntity;
import com.abulibde.perfectbathroom.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;


public class PerfectBathroomUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public PerfectBathroomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .map(PerfectBathroomUserDetailsService::map)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User " + username + " is not found"));

    }

    private static UserDetails map(UserEntity userEntity) {

        return User
                .withUsername(userEntity.getUsername())
                .password(userEntity.getPassword())
                .authorities(userEntity
                        .getRoles()
                        .stream()
                        .map(PerfectBathroomUserDetailsService::map)
                        .toList())
                .build();

    }

    private static GrantedAuthority map(UserRoleEntity userRoleEntity) {
        return new SimpleGrantedAuthority(
                "ROLE_" + userRoleEntity.getRole().name());
    }
}
