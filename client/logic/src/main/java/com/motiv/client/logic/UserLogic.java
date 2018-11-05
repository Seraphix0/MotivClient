package com.motiv.client.logic;

import com.motiv.client.interfaces.IUserRepository;
import com.motiv.client.models.User;

import java.util.List;

public class UserLogic {

    private static IUserRepository userRepository;

    public UserLogic(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void addUser(User user) {
        userRepository.create(user);
    }

    public User getUser(int id) {
        return userRepository.read(id);
    }

    public void modifyUser(User user) {
        userRepository.update(user);
    }

    public void removeUser(int id) {
        userRepository.delete(id);
    }

    public List<User> getAllUsers() {
        return userRepository.readAll();
    }
}
