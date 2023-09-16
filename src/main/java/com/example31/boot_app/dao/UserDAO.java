package com.example31.boot_app.dao;


import com.example31.boot_app.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAllUsers();
    User show(int id);
    void save(User user);
    void delete(int id);
    void update(int id, User user);
}
