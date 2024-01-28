package com.kidrola.rest.webservices.product.service;

import java.util.ArrayList;
import java.util.List;

import com.kidrola.rest.webservices.product.bean.Product;
import com.kidrola.rest.webservices.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
public class ProductHardCoadedService {
	
	private static List<Product> products = new ArrayList<Product>();
	
	@Autowired
    private ProductRepository productRepo;

	// this method is already defined in the JPA repository
	public List<Product> findAll() {
		System.out.println("find all running: "+products);
	    return productRepo.findAll();
	}
	
	public ResponseEntity<?> deleteById(long id) {
	    Product product = findById(id);
	    System.out.println("Product to be deleted: " + product + " and id " + id);

	    if (product == null) {
	        System.out.println("Product not found for deletion. Returning error message.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found for deletion");
	    } else {
	        if (products.remove(product)) {
	        	productRepo.delete(product);
	        	System.out.println("remove::: "+products.remove(product));
	            System.out.println("The product removed is: " + product);
	            return ResponseEntity.status(HttpStatus.OK).body(product);  // Return the deleted product on successful removal
	        } else {
	            System.out.println("Failed to remove the product. Returning error message.");
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to remove the product");
	        }
	    }
	}
	
	public Product saveProduct(Product product) {
	    return productRepo.save(product);
	}

	public Product findById(long id) {
		products = productRepo.findAll();
		System.out.println("findById is running" + products);
		System.out.println("Products: "+products);
		for(Product product: products) {
			System.out.println("The product to be removed is: " + product);

			if(product.getProductId() == id) {
				System.out.println("The product Id is: "+product.getProductId());
				System.out.println("The product Id is: "+product.getProductName());
				return product;
			}
		}
		return null;
	}
}

