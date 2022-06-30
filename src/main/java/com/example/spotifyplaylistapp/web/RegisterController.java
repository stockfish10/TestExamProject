package com.example.spotifyplaylistapp.web;

import com.example.spotifyplaylistapp.model.dto.UserRegisterDTO;
import com.example.spotifyplaylistapp.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
public class RegisterController {

    private UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userModel")
    public void initUserModel(Model model){
        model.addAttribute("userModel", new UserRegisterDTO());
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String register(@Valid UserRegisterDTO userModel,
                           BindingResult bindingResult,
                           RedirectAttributes  redirectAttributes){
        if (bindingResult.hasErrors()){
            redirectAttributes.addFlashAttribute("userModel", userModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userModel",bindingResult);

            return "redirect:/register";
        }
        userService.registerAndLogin(userModel);
        return "redirect:/home";
    }
}
