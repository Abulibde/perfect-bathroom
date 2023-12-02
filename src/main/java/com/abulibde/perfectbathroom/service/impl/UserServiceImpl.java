package com.abulibde.perfectbathroom.service.impl;

import com.abulibde.perfectbathroom.model.dto.UserRegistrationDTO;
import com.abulibde.perfectbathroom.model.dto.UserServiceModel;
import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.model.enums.UserRolesEnum;
import com.abulibde.perfectbathroom.repository.UserRepository;
import com.abulibde.perfectbathroom.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    private final ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.modelMapper = modelMapper;
    }

    @Override
    public void registerUser(UserRegistrationDTO userRegisterDTO) {
        userRepository.save(map(userRegisterDTO));
    }

    @Override
    public UserServiceModel findByUsernameAndPassword(String username, String password) {

        return userRepository.findByUsernameAndPassword(username,password)
                .map(user -> modelMapper.map(user, UserServiceModel.class))
                .orElse(null);    }



    private UserEntity map(UserRegistrationDTO userRegistrationDTO) {

        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRegistrationDTO.getUsername());
        userEntity.setFullName(userRegistrationDTO.getFullName());
        userEntity.setEmail(userRegistrationDTO.getEmail());
        userEntity.setPhoneNumber(userRegistrationDTO.getPhoneNumber());
        userEntity.setPassword(passwordEncoder.encode(userRegistrationDTO.getPassword()));
        userEntity.setRole(UserRolesEnum.USER);
        userEntity.setActive(true);

        return userEntity;
    }
}
