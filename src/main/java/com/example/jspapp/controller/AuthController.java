package com.example.jspapp.controller;

import com.example.jspapp.entity.Users;
import com.example.jspapp.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public String signUp(Users user, RedirectAttributes redirectAttributes) {
        boolean isSignUp = authService.registerUser(user);
        if (isSignUp) {
            System.out.println("User Register & Login");
            return "redirect:/homepage";
        } else {
            redirectAttributes.addFlashAttribute("error", "This account already exists");
            return "redirect:/";
        }

    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, RedirectAttributes redirectAttributes) {
        boolean isLogin = authService.loginUser(email, password);
        if (isLogin) {
            System.out.println("User Login");
            return "redirect:/homepage";
        } else {
            redirectAttributes.addFlashAttribute("error", "Email or password is incorrect");
            return "redirect:/";
        }
    }
}
