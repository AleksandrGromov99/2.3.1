package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import web.service.UserServiceImpl;

import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {
    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showUsers(Model model) {
        List<User> usersList = userService.getUserList();
        model.addAttribute("usersList", usersList);
        return "users";
    }

    @RequestMapping("/userInfo")
    public String showAddUserPage(Model model) {
        model.addAttribute("user", new User());
        return "addUser";
    }

    @RequestMapping("/saveUser")
    public String saveUser(@ModelAttribute("user") User user) {
        if(user.getId() == 0) {
            userService.saveUser(user);
        } else {
            userService.updateUser(user);
        }
        return "redirect:/";
    }

    @RequestMapping(value = { "/updateUser" })
    public String updateUser(@RequestParam("id") int id, Model model){
        User user = userService.getUser(id);
        model.addAttribute("user",user);
        return "addUser";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}
