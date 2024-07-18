package com.example.CRUD.controller;

import com.example.CRUD.domain.User;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/users/new")
    public String createForm(){
        return "users/createUserForm";
    }

    @PostMapping("/users/new")
    public String cretae(UserForm form){
        User user = new User();
        user.setName(form.getName());

        userService.registerUser(user);

        System.out.println(user.getId());
        System.out.println(user.getName());
        return "redirect:/";
    }

    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "users/showUsers";
    }

}
