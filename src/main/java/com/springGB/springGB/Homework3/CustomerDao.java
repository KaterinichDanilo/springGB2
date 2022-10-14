package com.springGB.springGB.Homework3;

import java.util.List;

public interface CustomerDao {
    Customer findById(Long id);
    List<Customer> findAll();
    Customer findByName(String name);
    void addProductById(Long id);
    List<Product> getProductListById(Long id);
    void addProductById(Long custId, Product product);
}
