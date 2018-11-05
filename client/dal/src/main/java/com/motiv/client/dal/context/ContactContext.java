package com.motiv.client.dal.context;

import com.motiv.client.dal.HibernateManager;
import com.motiv.client.interfaces.IContactContext;
import com.motiv.client.models.Contact;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class ContactContext implements IContactContext {
    private SessionFactory sessionFactory;

    public ContactContext() {
        this.sessionFactory = HibernateManager.getInstance().getSessionFactory();
    }

    public ContactContext(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Contact> readAll() {
        Session session = this.sessionFactory.openSession();

        Query<Contact> query = session.createQuery("FROM Contact", Contact.class);

        return query.list();
    }

    @Override
    public void create(Contact contact) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.save(contact);

        session.getTransaction().commit();
    }

    @Override
    public Contact read(int id) {
        Session session = this.sessionFactory.openSession();

        Query<Contact> query = session.createQuery("FROM Contact WHERE id = :id", Contact.class);
        query.setParameter("id", id);

        return query.uniqueResult();
    }

    @Override
    public void update(Contact contact) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.update(contact);

        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("DELETE FROM Contact where id = :id", Contact.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}

