package com.motiv.client.repository;

import com.motiv.client.interfaces.IContactContext;
import com.motiv.client.interfaces.IContactRepository;
import com.motiv.client.models.Contact;

import java.util.List;

public class ContactRepository implements IContactRepository {

    private IContactContext contactContext;

    public ContactRepository(IContactContext contactContext) {
        this.contactContext = contactContext;
    }

    public List<Contact> readAll() {
        return this.contactContext.readAll();
    }

    public void create(Contact contact) {
        this.contactContext.create(contact);
    }

    public Contact read(int id) {
        return this.contactContext.read(id);
    }

    public void update(Contact contact) {
        this.contactContext.update(contact);
    }

    public void delete(int id) {
        this.contactContext.delete(id);
    }
}
