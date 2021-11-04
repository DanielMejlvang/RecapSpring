package com.caer.recapspring.Controller;

import com.caer.recapspring.Model.User;
import com.caer.recapspring.Service.NoteService;
import com.caer.recapspring.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    UserService userService;

//    private List<User> users = new ArrayList<>();

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("users", userService.listUsersInDatabase());
        return "index";
    }

    @PostMapping("/createUser")
    public String createUser(@ModelAttribute User user) {
        System.out.println(user.getUsername() + " " + user.getId() + " has been saved.");
        userService.addUserToDatabase(user);
        return "redirect:/";
    }

    @GetMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userService.deleteUserFromDatabase(id);
//        users.removeIf(user -> user.getId().equals(id));
        return "redirect:/";
    }

    @GetMapping("/updateUser/{id}")
    public String updateUser(Model model, @PathVariable("id") String id) {
        model.addAttribute("user", userService.findUserById(id));
        return "/updateUser";
    }

    @PostMapping("/updateUser")
    public String updateUser(@ModelAttribute User user) {
        userService.updateUserInDatabase(user);
        return "redirect:/";
    }
}
