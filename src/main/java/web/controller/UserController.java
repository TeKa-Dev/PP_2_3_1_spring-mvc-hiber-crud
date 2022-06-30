package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import web.model.User;
import web.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String showUsers(ModelMap models) {
        models.addAttribute("users", userService.getUsers());
        return "users_page";
    }

    @RequestMapping("/add")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "edit_page";
    }

    @RequestMapping("/update{id}")
    public String updateUser(@PathVariable Long id, Model model) {
        model.addAttribute(userService.getUser(id));
        return "edit_page";
    }

    @RequestMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/";
    }

    @RequestMapping("/delete{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
