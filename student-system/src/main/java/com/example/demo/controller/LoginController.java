package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class LoginController {

    @GetMapping("/")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password,
                        Model model) {
        if(username.equals("admin") && password.equals("admin123")) {
            return "redirect:/studentForm";
        } else {
            model.addAttribute("error","Invalid Credentials");
            return "login";
        }
    }
}
