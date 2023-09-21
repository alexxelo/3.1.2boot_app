package com.example31.boot_app.dao;

import com.example31.boot_app.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class UserDAOImpl implements UserDAO {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("SELECT user FROM User user", User.class).getResultList();
    }

    @Override
    public User show(int id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void save(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(int id) {
        entityManager
                .createQuery("DELETE FROM User WHERE id =:userId")
                .setParameter("userId", id)
                .executeUpdate();
    }

    @Override
    public void update(int id, User updatedUser) {
        User userToBeUpdated = entityManager.merge(updatedUser);
        userToBeUpdated.setName(updatedUser.getName());
        userToBeUpdated.setAge(updatedUser.getAge());
        entityManager.flush();
    }
}
