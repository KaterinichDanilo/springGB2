package com.springGB.springGB.Homework3;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductDaoImp implements ProductDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public ProductDaoImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    @Override
    public Product findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            System.out.println("prod find committed");
            return product;
        }
    }

    @Override
    public List<Product> findAll() {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            List<Product> products = session.createQuery("SELECT p FROM Product p").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }

    @Override
    public Product findByTitle(String title) {
        try(Session session = sessionFactoryUtils.getSession()){
            session.beginTransaction();
            Product product = session.createQuery("SELECT p FROM Product p WHERE p.title = :title", Product.class)
                    .setParameter("title", title).getSingleResult();
            session.getTransaction().commit();
            return product;
        }
    }
}
