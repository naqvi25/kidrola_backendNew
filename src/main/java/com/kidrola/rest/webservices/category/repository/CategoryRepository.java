package com.kidrola.rest.webservices.category.repository;

import com.kidrola.rest.webservices.category.bean.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
//
//package com.kidrola.rest.webservices.product;
//
//
//public interface ProductRepository extends JpaRepository<Product, Long> {}