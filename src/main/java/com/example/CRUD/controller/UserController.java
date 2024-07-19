package com.example.CRUD.controller;

import com.example.CRUD.domain.User;
import com.example.CRUD.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    // 템플릿 유저 생성
    @GetMapping("/users/new")
    public String createForm(){
        return "users/createUserForm";
    }

    // 유저 생성
    @PostMapping("/users/new")
    public String cretae(@RequestBody User user){
        user.setName(user.getName());

        userService.registerUser(user);

        System.out.println(user.getId());
        System.out.println(user.getName());
        return "redirect:/";
    }

    // 전체 유저 조회
    @GetMapping("/users")
    public String showUsers(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users",users);
        return "users/showUsers";
    }

    // 유저 조회
    @GetMapping("/user")
    public String showUser(@RequestParam("id") Long id, Model model) {
            Optional<User> user = userService.findById(id);
            model.addAttribute("user", user.get());
            return "users/showUser";
    }

    @DeleteMapping("/user")
    public String deleteUser(@RequestBody User user) {
        userService.deleteUser(user.getName());
        return "redirect:/";
    }

    @PutMapping("/user")
    public String updateUser(@RequestParam("id") Long id, @RequestBody User user){
        userService.updateUser(id, user.getName());
        return "redirect:/";
    }
}
