package com.springGB.springGB.Homework3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repository;

    public String getTitleById(Long id) {
        return repository.findById(id).getTitle();
    }

    public Product getProductById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getListProducts() {
        return repository.getProductList();
    }

    public void add(Product product) {
        repository.getProductList().add(product);
    }
}
