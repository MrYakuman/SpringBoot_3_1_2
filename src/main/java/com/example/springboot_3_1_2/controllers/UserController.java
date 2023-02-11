package com.example.springboot_3_1_2.controllers;

import com.example.springboot_3_1_2.model.User;
import com.example.springboot_3_1_2.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

    private UserServiceImp userServiceImp;

    @Autowired
    public UserController(UserServiceImp userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping
    public String printWelcome(ModelMap model) {
        List<User> users = userServiceImp.showAll();
        model.addAttribute("users", users);
        return "index";
    }

    @PostMapping
    public String create(@ModelAttribute("user") User user) {
        userServiceImp.create(user);
        return "redirect:/";

    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userServiceImp.show(Math.toIntExact(id)));
        return "/show";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user) {
        userServiceImp.update(user);
        return "redirect:/";
    }

    @GetMapping("/new")
    public String newPerson(@ModelAttribute("user") User user) {
        return "/newUser";
    }


    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("user", userServiceImp.show(Math.toIntExact(id)));
        return "/edit";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        userServiceImp.delete(Math.toIntExact(id));
        return "redirect:/";
    }


}
