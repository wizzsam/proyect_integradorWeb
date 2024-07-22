/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package service;

/**
 *
 * @author abelp
 */
import dao.UserDao;
import model.User;

public class UserService {
    private UserDao userDao;

    public UserService() {
        userDao = new UserDao();
    }

    public boolean registerUser(User user) {
        return userDao.addUser(user);
    }

    public boolean validateUser(String username, String password) {
        return userDao.validateUser(username, password);
    }
    
   public int getUserIdByUsername(String username) {
        return userDao.getUserIdByUsername(username);
    }
}