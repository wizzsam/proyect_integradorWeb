/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

import model.User;
import service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.IOException;
import jakarta.faces.context.FacesContext;

@Named
@RequestScoped
public class RegisterBean {
    private String username;
    private String password;
    private String email;

    @Inject
    private UserService userService;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void register() throws IOException {
        User user = new User(username, password, email);
        userService.registerUser(user);
        FacesContext.getCurrentInstance().getExternalContext().redirect("login.xhtml");
    }
}