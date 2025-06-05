/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.UserDao;
import java.sql.SQLException;

/**
 *
 * @author nicop
 */
public class UserController {

    private final UserDao userDao;

    public UserController() {
        this.userDao = new UserDao();
    }

    public void createUser(String username, String password, String passwordRep) throws SQLException, IllegalArgumentException {
        if (username.isEmpty() || password.isEmpty() || passwordRep.isEmpty()) {
            throw new IllegalArgumentException("Todos los campos son obligatorios.");
        }
        if (!password.equals(passwordRep)) {
            throw new IllegalArgumentException("Las contraseñas no coinciden.");
        }
        if (userDao.existsByUsername(username)) {
            throw new IllegalArgumentException("El nombre de usuario ya existe.");
        }
        userDao.createUser(username, password);
    }
}
