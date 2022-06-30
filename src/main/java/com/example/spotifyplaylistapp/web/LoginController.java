package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.UserLoginDTO;
import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping
public class LoginController {

    private UserService userService;


    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public void initUserModel(Model model){
        model.addAttribute("userModel", new UserLoginDTO());
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/logout")
    public String logout() {
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/login")
    public String login(@Valid UserLoginDTO userModel,
                        BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "redirect:/login";
        }
        userService.login(userModel);
        System.out.println("User is logged: " + userService.login(userModel));
        return "redirect:/home";
    }

}
