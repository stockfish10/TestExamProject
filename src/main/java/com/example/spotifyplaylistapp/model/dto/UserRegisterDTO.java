package com.example.spotifyplaylistapp.model.dto;

import com.example.spotifyplaylistapp.model.validation.PasswordMatch;
import com.example.spotifyplaylistapp.model.validation.UniqueUsername;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@PasswordMatch(
        first = "password",
        second = "confirmPassword",
        message = "Passwords must match"
)
public class UserRegisterDTO {

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 3,max = 20,message = "Size must be between 3 and 20 symbols")
    @UniqueUsername(message = "Username should be unique")
    private String username;

    @Email(message = "Invalid email address")
    @NotEmpty(message = "Email must be provided")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 3,max = 20,message = "Password length must be between 3 and 20 symbols")
    private String password;

    @NotEmpty
    @Size(min = 3,max = 20)
    private String confirmPassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
