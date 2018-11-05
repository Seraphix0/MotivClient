package com.motiv.client.dal.context;

import com.motiv.client.dal.HibernateManager;
import com.motiv.client.interfaces.IUserContext;
import com.motiv.client.models.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class UserContext implements IUserContext {
    private SessionFactory sessionFactory;

    public UserContext() {
        this.sessionFactory = HibernateManager.getInstance().getSessionFactory();
    }

    public UserContext(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<User> readAll() {
        Session session = this.sessionFactory.openSession();

        Query<User> query = session.createQuery("FROM Contact", User.class);

        return query.list();
    }

    @Override
    public void create(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.save(user);

        session.getTransaction().commit();
    }

    @Override
    public User read(int id) {
        Session session = this.sessionFactory.openSession();

        Query<User> query = session.createQuery("FROM Contact WHERE id = :id", User.class);
        query.setParameter("id", id);

        return query.uniqueResult();
    }

    @Override
    public void update(User user) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();

        session.update(user);

        session.getTransaction().commit();
    }

    @Override
    public void delete(int id) {
        Session session = this.sessionFactory.openSession();

        Query query = session.createQuery("DELETE FROM Contact where id = :id", User.class);
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
