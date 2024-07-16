/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bean;

/**
 *
 * @author abelp
 */
import service.UserService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
import jakarta.inject.Inject;
import java.io.Serializable;

@Named
@RequestScoped
public class LoginBean implements Serializable {
    private String username;
    private String password;

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

    public String login() {
        if (userService.validateUser(username, password)) {
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("username", username);
            System.out.println("Usuario guardado en sesión: " + username);  // Línea para depuración
            return "index?faces-redirect=true"; // Redirige a la página de inicio después de iniciar sesión
        } else {
            return "login"; // Mantente en la página de inicio de sesión
        }
    }

    public String logout() {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login?faces-redirect=true"; // Redirige a la página de inicio de sesión después de cerrar sesión
    }

    public boolean isLoggedIn() {
        return FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username") != null;
    }

    public String getSessionUsername() {
        return (String) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("username");
    }
}