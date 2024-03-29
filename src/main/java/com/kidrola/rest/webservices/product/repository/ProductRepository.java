package com.kidrola.rest.webservices.product.repository;

import com.kidrola.rest.webservices.product.bean.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {}