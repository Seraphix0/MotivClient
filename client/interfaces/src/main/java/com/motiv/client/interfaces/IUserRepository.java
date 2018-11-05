package com.motiv.client.interfaces;

import com.motiv.client.models.User;

import java.util.List;

public interface IUserRepository {
    List<User> readAll();
    void create(User user);
    User read(int id);
    void update(User user);
    void delete(int id);
}
