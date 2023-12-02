package com.abulibde.perfectbathroom.service;

import com.abulibde.perfectbathroom.model.dto.UserLoginDTO;
import com.abulibde.perfectbathroom.model.dto.UserRegistrationDTO;
import com.abulibde.perfectbathroom.model.dto.UserServiceModel;
import com.abulibde.perfectbathroom.model.entity.UserEntity;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegisterDTO);


    UserServiceModel findByUsernameAndPassword(String username, String password);

}
