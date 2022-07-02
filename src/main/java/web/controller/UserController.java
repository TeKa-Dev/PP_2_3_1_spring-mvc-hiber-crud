package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "users_page";
    }

    @GetMapping("/add")
    public String createUser(User user) {
        return "edit_page";
    }

    @PostMapping ("/save")
    public String saveUser(User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/update{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "edit_page";
    }

    @GetMapping("/delete{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
