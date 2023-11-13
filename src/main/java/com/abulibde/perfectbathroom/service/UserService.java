package com.abulibde.perfectbathroom.service;

import com.abulibde.perfectbathroom.model.dto.UserLoginDTO;
import com.abulibde.perfectbathroom.model.dto.UserRegistrationDTO;
import com.abulibde.perfectbathroom.model.entity.UserEntity;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegisterDTO);


    UserEntity findByUsernameAndPassword(String username, String password);

    void loginUser(Long id, String username);
}
