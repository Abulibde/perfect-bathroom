package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.model.dto.userDTO.UserRegistrationDTO;
import com.abulibde.perfectbathroom.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
public class UserRegistrationController {

    private final UserService userService;

    public UserRegistrationController(UserService userService){

        this.userService = userService;
    }
    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String register(UserRegistrationDTO userRegisterDTO) {

        userService.registerUser(userRegisterDTO);

        return "redirect:/";
    }

}
