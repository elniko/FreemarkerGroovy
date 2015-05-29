package beans;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Nick on 27/05/2015.
 */
@Controller
@RequestMapping("/")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    List<User> users = new ArrayList<>();

    @ModelAttribute(value = "user")
    public User addUserAttribute() {
        User user = new User();
        user.setLogin("Login");
        user.setPass("pass");
        user.setEmail("mail");
        user.setSex("male");
        return user;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        Map<String, String> sex = new HashMap<>();
        sex.put("male", "male");
        sex.put("female", "female");
        model.addAttribute("sex", sex);
        model.addAttribute("users", users);
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)

    public String saveUser(@ModelAttribute("user") User user,  RedirectAttributes redirectAttrs) {
        users.add(user);
        redirectAttrs.addFlashAttribute("message", "User created!");
        return "redirect:/user";
       // return "Hello " + user.getLogin() + " " + user.getPass() + " " + user.getEmail() + " " + user.getSex() + "" + user.getRole().toString() ;
    }
}
