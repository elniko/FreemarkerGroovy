package beans;

import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
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


    @Autowired
    @Qualifier(value = "groovyValidator")
    Validator validator;

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hello";
    }

    List<User> users = new ArrayList<>();

    @ModelAttribute(value = "user")
    public User addUserAttribute(Model model) {
        User user = new User();
        user.setLogin("Login");
        user.setPass("pass");
        user.setEmail("mail");
        user.setSex("male");
        return user;
    }
    @ModelAttribute(value = "users")
    public  List<User> addUsers() {
        return users;
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public String showUserForm(Model model) {
        return "user";
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public String saveUser(@Valid @ModelAttribute(value = "user")  User user, BindingResult result, RedirectAttributes redirectAttrs, Model model) {

        validator.validate(user, result);

        if(result.hasErrors()) {
            model.addAllAttributes(result.getModel());
            model.addAttribute("error", "Form has errors");
            return "user";
        }
        users.add(user);
        redirectAttrs.addFlashAttribute("message", "User created!");
        return "redirect:/user";
       // return "Hello " + user.getLogin() + " " + user.getPass() + " " + user.getEmail() + " " + user.getSex() + "" + user.getRole().toString() ;
    }
}
