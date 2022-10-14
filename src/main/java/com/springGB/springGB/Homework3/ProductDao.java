package com.springGB.springGB.Homework3;

import java.util.List;

public interface ProductDao {
    Product findById(Long id);
    List<Product> findAll();
    Product findByTitle(String title);
}
