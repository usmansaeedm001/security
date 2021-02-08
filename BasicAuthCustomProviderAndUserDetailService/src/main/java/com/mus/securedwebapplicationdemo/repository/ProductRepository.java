package com.mus.securedwebapplicationdemo.repository;

import com.mus.securedwebapplicationdemo.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
