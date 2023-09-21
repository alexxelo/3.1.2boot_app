package com.example31.boot_app.controller;

import com.example31.boot_app.model.User;
import com.example31.boot_app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("user", userService.getAllUsers());
        return "pages/index";

    }
    @GetMapping("/new")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "pages/new";
    }
    @PostMapping()
    public String createUser(@ModelAttribute("user") User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "pages/new";
        }
        userService.save(user);

        return "redirect:/";

    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable("id") int id, Model model) {
        userService.delete(id);
        model.addAttribute("user", userService.show(id));
        return "redirect:/";

    }
    @GetMapping("/{id}/edit")
    public String editUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "pages/edit";

    }
    @PatchMapping("/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable("id") int id) {
        userService.update(id, user);
        return "redirect:/";

    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", userService.show(id));
        return "pages/show";

    }
}
