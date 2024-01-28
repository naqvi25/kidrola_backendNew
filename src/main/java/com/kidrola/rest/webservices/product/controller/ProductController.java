package com.kidrola.rest.webservices.product.controller;

import java.net.URI;
import java.util.List;

import com.kidrola.rest.webservices.product.bean.Product;
import com.kidrola.rest.webservices.product.service.ProductHardCoadedService;
import com.kidrola.rest.webservices.product.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

//@RestController // shows that this is a bean
@CrossOrigin(origins = "*")
@RestController
public class ProductController {
	
	@Autowired
	private ProductHardCoadedService productService;
	
	@Autowired
    private ProductRepository productRepo;
	
//	@RequestMapping(method=RequestMethod.GET, path= "/products")	
	@GetMapping(path= "/api/products")
	public List retrieveAllProducts() {
		System.out.println("This is retrieve all products method");
		System.out.println("retrieveAllProducts() running");
		System.out.println("This is retrieve all products method");
        return productRepo.findAll();
	}
	
	
	@GetMapping(path= "/productById/{productId}")
	public Product getProductById(@PathVariable long productId) {
		System.out.println("getProductById running");
		return productService.findById(productId);
	}
	
//	@CrossOrigin(origins = "http://localhost:4201")
	@PutMapping(path= "/updateProduct/{productId}")
	public ResponseEntity<Product> updateProduct(@PathVariable long productId, @RequestBody Product product) {
		Product updatedProduct = productService.saveProduct(product);
		System.out.println("updated product on Put Request: "+ updatedProduct);
		return new ResponseEntity<Product>(updatedProduct, HttpStatus.OK);
	}
	
//	@CrossOrigin(origins = "*")
	@PostMapping(path= "/addProduct")
	public ResponseEntity<Void> addProduct(@RequestBody Product product) {
		Product newProduct = productService.saveProduct(product);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newProduct.getProductId()).toUri();
		System.out.println("New Product added on Post Request: "+newProduct);
		return ResponseEntity.created(uri).build();
	}
	
//	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
////	@DeleteMapping("/product/{productId}")
//	public ResponseEntity<Void> deleteProduct(
//			@PathVariable long productId) {
//			Product product = (Product) productService.deleteById(productId);
//			System.out.println("Prodd: "+product);
//			System.out.println("Prodd ID: "+productId);
//		
//			if(product !=null) {
//				return ResponseEntity.noContent().build();
//			}
//		return ResponseEntity.notFound().build();
//	}
	
	@RequestMapping(value = "/product/{productId}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteProduct(@PathVariable long productId) {
	    ResponseEntity<?> responseEntity = productService.deleteById(productId);
	    HttpStatus statusCode = (HttpStatus) responseEntity.getStatusCode();

	    if (statusCode == HttpStatus.OK || statusCode == HttpStatus.NO_CONTENT) {
	        // The request was successful (OK or NO_CONTENT)
	        // Assuming ProductService returns ResponseEntity<Void> for successful deletions
	        System.out.println("Product deleted successfully."+ responseEntity);
//	        return ResponseEntity.ok("Deleted!");
	        return responseEntity;
	    } else if (statusCode == HttpStatus.NOT_FOUND) {
	        // Product not found
	        System.out.println("Product not found.");
	        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
	    } else {
	        // Handle other response types or errors
	        System.out.println("Unexpected response: " + statusCode);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Internal Server Error");
	    }
	}


}
