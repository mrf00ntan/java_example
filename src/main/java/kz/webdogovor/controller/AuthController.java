package kz.webdogovor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {
    @GetMapping("/")
    public String showLoginPage(Model model) {
        return "login";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied(Model model) {
        return "error/access-denied";
    }

}
