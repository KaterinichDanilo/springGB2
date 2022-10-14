package com.springGB.springGB.Homework3;

import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImp implements CustomerDao{
    private SessionFactoryUtils sessionFactoryUtils;

    public CustomerDaoImp(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }
    @Override
    public Customer findById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, id);
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public List<Customer> findAll() {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
            session.getTransaction().commit();
            return customers;
        }
    }

    @Override
    public Customer findByName(String name) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.createQuery("select c from Customer c where c.name = :name", Customer.class)
                    .setParameter("name", name).getSingleResult();
            session.getTransaction().commit();
            return customer;
        }
    }

    @Override
    public void addProductById(Long id) {

    }

    @Override
    public List<Product> getProductListById(Long id) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = findById(id);
            List<Product> productList = customer.getProducts();
            session.getTransaction().commit();
            return productList;
        }
    }

    @Override
    public void addProductById(Long custId, Product product) {
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = findById(custId);
            customer.getProducts().add(product);
            session.getTransaction().commit();
        }
    }
}
