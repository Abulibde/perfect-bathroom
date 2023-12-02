package com.abulibde.perfectbathroom.web;

import com.abulibde.perfectbathroom.model.dto.UserLoginDTO;
import com.abulibde.perfectbathroom.model.dto.UserServiceModel;
import com.abulibde.perfectbathroom.model.entity.UserEntity;
import com.abulibde.perfectbathroom.service.UserService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/users")
public class UserLoginController {

    private final UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userLoginDTO,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);

            redirectAttributes
                    .addFlashAttribute(
                            "org.springframework.validation.BindingResult.userLoginDTO",
                            bindingResult);

            return "redirect:login";
        }

        UserServiceModel userServiceModel = userService.findByUsernameAndPassword(
                userLoginDTO.getUsername(), userLoginDTO.getPassword());

        if (userServiceModel == null) {
            redirectAttributes.addFlashAttribute("userLoginDTO", userLoginDTO);
            redirectAttributes.addFlashAttribute("isFound", false);
            return "redirect:login";
        }

        userService.loginUser(userServiceModel.getId(), userLoginDTO.getUsername());

        return "redirect:/";
    }
}
