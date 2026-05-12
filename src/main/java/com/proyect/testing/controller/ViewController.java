package com.proyect.testing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyect.testing.model.User;
import com.proyect.testing.service.UserService;



@Controller
public class ViewController {
@Autowired
private UserService uService;
    
    @GetMapping("/login")
    public String login() {
        return "login";
    }

    
    @GetMapping("/users")
    public String users(Model model) {
        model.addAttribute("users", uService.getAllUsers());
        return "users";
    }

   
    @GetMapping("/users/edit/{id}")
    public String editUser(@PathVariable Long id, Model model) {
        User user = uService.getById(id);
        model.addAttribute("user",user);
        return "edit-new";
    }

    @GetMapping("/users/create")
    public String createForm(Model model) {
    model.addAttribute("user", new User());
    return "edit-new";
    }

    @PostMapping("/users/save")
    public String save(User user) {
        if (user.getId() != null) {
        uService.updateUser(user.getId(), user);
    } else {
        uService.createUser(user);
    }
        return "redirect:/users";
    
    }
}
