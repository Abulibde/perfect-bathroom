package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.dto.UserRegistrationDTO;
import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.model.enums.UserRolesEnum;
import com.abulibde.perfectbathroom.repository.UserRepository;
import com.abulibde.perfectbathroom.service.UserService;
import com.abulibde.perfectbathroom.util.CurrentUser;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final CurrentUser currentUser;

    public UserServiceImpl(UserRepository userRepository, CurrentUser currentUser) {
        this.userRepository = userRepository;
        this.currentUser = currentUser;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegisterDTO) {
        userRepository.save(map(userRegisterDTO));
    }

    @Override
    public UserEntity findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username,password).orElse(null);
    }

    @Override
    public void loginUser(Long id, String username) {
        currentUser.setId(id);
        currentUser.setUsername(username);
    }


    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistrationDTO.getUsername());
        userEntity.setFullName(userRegistrationDTO.getFullName());
        userEntity.setEmail(userRegistrationDTO.getEmail());
        userEntity.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        userEntity.setPassword(userRegistrationDTO.getPassword());
        userEntity.setRole(UserRolesEnum.USER);
        userEntity.setActive(true);

        return userEntity;
    }
}
