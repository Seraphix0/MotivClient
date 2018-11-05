package com.motiv.client.dal;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
    private static HibernateManager instance = new HibernateManager();

    private final SessionFactory sessionFactory = buildSessionFactory();

    private HibernateManager() { }

    public static HibernateManager getInstance() {
        return instance;
    }

    private SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void shutdown() {
        getSessionFactory().close();
    }
}
