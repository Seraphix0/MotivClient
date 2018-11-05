package com.motiv.client.factory;

import com.motiv.client.dal.context.ContactContext;
import com.motiv.client.dal.context.UserContext;
import com.motiv.client.logic.ContactLogic;
import com.motiv.client.logic.UserLogic;
import com.motiv.client.repository.ContactRepository;
import com.motiv.client.repository.UserRepository;

public class Factory {
    private static Factory instance = new Factory();

    private Factory() {}

    public static Factory getInstance() {
        return instance;
    }

    public UserLogic getUserLogic() {
        return new UserLogic(new UserRepository(new UserContext()));
    }

    public ContactLogic getContactLogic() {
        return new ContactLogic(new ContactRepository(new ContactContext()));
    }
}