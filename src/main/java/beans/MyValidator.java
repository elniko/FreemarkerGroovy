package beans;


import entities.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * Created by Nick on 01/06/2015.
 */

public class MyValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        if(user.getLogin().equals("login")) {
            errors.reject("user.badName", "Bad name");
        }
    }
}
