package beans;

import entities.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @ModelAttribute(value = "user")
    public User addUserAttribute() {
        User user = new User();
        user.setLogin("Login");
        user.setPass("pass");
        user.setEmail("mail");
        return user;
    }


    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm() {
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    @ResponseBody
    public String saveUser(@ModelAttribute("user") User user) {
        return "Hello " + user.getLogin() + " " + user.getPass() + " " + user.getEmail();
    }
}
