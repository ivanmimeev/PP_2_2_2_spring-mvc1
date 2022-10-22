package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

@RequestMapping("/users")
@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String allUsers(ModelMap model) {
        model.addAttribute("users", this.userService.allUser());
        return "users";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String editPage(@PathVariable(value = "id") long id, Model model) {
        User user = userService.getById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.PATCH)
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/users";
    }

    @GetMapping(value = "/add")
    public String addPage(ModelMap model) {
        User user = new User();
        model.addAttribute("user", user);
        return "add";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/users";
    }
    @DeleteMapping(value="/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        this.userService.deleteById(id);
        return "redirect:/users";
    }
}
