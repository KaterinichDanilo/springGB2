package com.springGB.springGB.homework4;

import org.hibernate.HibernateException;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        sessionFactoryUtils.init();
        try {
            ProductDao productDao = new ProductDao(sessionFactoryUtils);
            System.out.println(productDao.findById(1L));

            List<Product> products = productDao.findAll();
            System.out.println(products);

            productDao.saveOrUpdateProduct(new Product("Bread", 12));
            products = productDao.findAll();
            System.out.println(products);

            Product del = productDao.findByTitle("Milk");
            productDao.deleteProduct(del);
            products = productDao.findAll();
            System.out.println(products);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            sessionFactoryUtils.shotDown();
        }
    }
}
