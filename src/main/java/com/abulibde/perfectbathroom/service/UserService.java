package com.abulibde.perfectbathroom.service;

import com.abulibde.perfectbathroom.model.dto.userDTO.UserRegistrationDTO;
import com.abulibde.perfectbathroom.model.dto.userDTO.UserServiceModel;

public interface UserService {
    void registerUser(UserRegistrationDTO userRegisterDTO);


    UserServiceModel findByUsernameAndPassword(String username, String password);

}
