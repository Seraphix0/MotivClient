package com.motiv.client.interfaces;

import com.motiv.client.models.Contact;

public interface IUserLogic {
    void addUser(Contact contact);
    Contact getUser(int id);
    void modifyUser(Contact contact);
    void removeUser(int id);
}
