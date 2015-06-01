package entities;

import com.sun.istack.internal.NotNull;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.Arrays;

/**
 * Created by Nick on 27/05/2015.
 */
public class User {

    @NotEmpty(message = "Error empty name")
    String login;

    @NotEmpty(message = "Error empty pass")
    String pass;

    @Email(message = "Error email ")
    String email;

    @NotEmpty(message = "Error empty sex")
    String sex ;

    @NotNull
    String role[];

    public String[] getRole() {
        return role;
    }

    public void setRole(String[] role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", login='" + login + '\'' +
                ", pass='" + pass + '\'' +
                ", sex='" + sex + '\'' +
                ", role=" + Arrays.toString(role) +
                '}';
    }
}
