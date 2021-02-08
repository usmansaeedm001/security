package com.mus.securedwebapplicationdemo.services;

import com.mus.securedwebapplicationdemo.model.Product;
import com.mus.securedwebapplicationdemo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> findAll(){
        return productRepository.findAll();
    }
}
