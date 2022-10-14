package com.springGB.springGB.Homework3;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerDaoImp customerDao;
    private final ProductDao productDao;

    public CustomerService(CustomerDaoImp customerDao, ProductDao productDao) {
        this.customerDao = customerDao;
        this.productDao = productDao;
    }

    public CustomerDaoImp getCustomerDao() {
        return customerDao;
    }

    public ProductDao getProductDao() {
        return productDao;
    }

    public List<Customer> getCustomers() {
        return customerDao.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerDao.findById(id);
    }

    public List<Product> getProductListByCustomerId(Long id) {
        return customerDao.getProductListById(id);
    }

    public void addProductById(Long custId, Long prodId) {
        customerDao.addProductById(custId, productDao.findById(prodId));
    }
}
