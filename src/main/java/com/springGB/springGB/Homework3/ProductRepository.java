package com.springGB.springGB.Homework3;

import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productList;

    @PostConstruct
    public void init() {
        productList = new ArrayList<>(Arrays.asList(
                new Product("Milk", 30),
                new Product("Apple", 12),
                new Product("Potato", 15),
                new Product("Carrot", 12),
                new Product("Pineapple", 20)
        ));
    }

    public List<Product> getProductList() {
        return productList;
    }

    public Product findById(Long id) {
        return productList.stream().filter(product -> product.getId().equals(id)).findAny().orElse(null);
    }

}
