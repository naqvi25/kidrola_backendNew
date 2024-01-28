package com.kidrola.rest.webservices.category.service;

import java.util.ArrayList;
import java.util.List;

import com.kidrola.rest.webservices.category.bean.Category;
import com.kidrola.rest.webservices.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;

//import com.kidrola.rest.webservices.product.bean.Product;
//import com.kidrola.rest.webservices.product.repository.ProductRepository;

public class CategoryHardCoadedService {
	
	private static List<Category> categories = new ArrayList();
	private static long idCounter = 0;
	
	@Autowired
    private CategoryRepository categoryRepo;

	// this method is already defined in the jpa repository
	public List<Category> findAll() {
		System.out.println(categories);
//		return products;
	    return categoryRepo.findAll();

	}
	
	public Category deleteById(long id) {
		Category category = findById(id);
		if(category == null) {
			return null;
		}
		if(categories.remove(category)) {
			categories.remove(category);
			System.out.println("The product to be removed is: " +category);
			return category;
		}
		return null;
	}
	
	public Category saveCategory(Category product) {

	    return categoryRepo.save(product);
	}

	public Category findById(long id) {
		for(Category category: categories) {
			if(category.getCategoryId() == id) {
				System.out.println("The product Id is: "+category.getCategoryId());
				System.out.println("The product Id is: "+category.getCategoryName());
				return category;
			}
		}
		return null;
	}

}
