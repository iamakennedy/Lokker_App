package org.launchcode.Lokker.R.models;

import org.hibernate.validator.constraints.Email;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity //tells springboot to store this class in a database
public class User {
    @Id
    @GeneratedValue
    private int id;

    @Email(message = "Invalid email address")
    private String email;

    @NotNull
    @Size(min=5, message = "Password must be at least 5 characters long")
    private String password;

    @NotNull(message = "Passwords do not match")
    private String verifyPassword;

    //////Please see below three lines for database integration/7:18 app working

    //@OneToMany
    //@JoinColumn (name = "user_id")
    //private List <Lokkers> lokkers = new Arraylist<>();

    ////////////////////////////////////////////////////////////
    public User(String email, String password) {
        this.email = email;
        this.password = password;
        this.id = getId();
    }

    public User() {}

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        checkPassword();
    }

    public String getVerifyPassword() {
        return verifyPassword;
    }

    public void setVerifyPassword(String verifyPassword) {
        this.verifyPassword = verifyPassword;
        checkPassword();
    }

    private void checkPassword() {
        if (password != null && verifyPassword != null
                && !password.equals(verifyPassword)) {
            verifyPassword = null;
        }
    }
}