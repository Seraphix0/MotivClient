package com.motiv.client.logic;

import com.motiv.client.interfaces.IUserRepository;
import com.motiv.client.models.User;

public class UserLogic {

    private static IUserRepository userRepository;

    public UserLogic(IUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    void addUser(User user) {

    }

    User getUser(int id) {
        return null;
    }

    void modifyUser(User user) {

    }

    void removeUser(int id) {

    }
}
