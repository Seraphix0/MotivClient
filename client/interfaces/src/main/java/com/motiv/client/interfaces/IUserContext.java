package com.motiv.client.interfaces;

import com.motiv.client.models.User;

import java.util.List;

public interface IUserContext {
    List<User> readAll();
    void create(User contact);
    User read(int id);
    void update(User contact);
    void delete(int id);
}
