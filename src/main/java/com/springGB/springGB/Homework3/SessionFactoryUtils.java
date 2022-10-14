package com.springGB.springGB.Homework3;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;

@Repository
public class SessionFactoryUtils {
    private SessionFactory factory;

    public Session getSession() {
        return factory.getCurrentSession();
    }

    @PostConstruct
    public void init() {
        factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public void shotDown() {
        if (factory != null) {
            factory.close();
        }
    }
}
