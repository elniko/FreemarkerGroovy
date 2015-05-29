package entities;

import com.sun.istack.internal.NotNull;

import java.util.Arrays;

/**
 * Created by Nick on 27/05/2015.
 */
public class User {

    @NotNull
    String login;

    String pass;

    String email;

    String sex ;

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
