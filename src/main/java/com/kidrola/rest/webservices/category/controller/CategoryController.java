package com.kidrola.rest.webservices.category.controller;

import java.net.URI;
import java.util.List;

import com.kidrola.rest.webservices.category.bean.Category;
import com.kidrola.rest.webservices.category.service.CategoryHardCoadedService;
import com.kidrola.rest.webservices.category.repository.CategoryRepository;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


public class CategoryController {
	
	@Autowired
	private CategoryHardCoadedService categoryService;
	
	@Autowired
    private CategoryRepository categoryRepo;
	
	@GetMapping(path= "/api/categories")
	public List retrieveAllCategories() {
		System.out.println("This is retrieve all categorys method");
		System.out.println("retrieveAllCategories() running");
		System.out.println("This is retrieve all categorys method");
        return categoryRepo.findAll();
	}
	
	
	@GetMapping(path= "/categoryById/{categoryId}")
	public Category getCategoryById(@PathVariable long categoryId) {
		System.out.println();
		return categoryService.findById(categoryId);
	}
	
	@PutMapping(path= "/updateCategory/{categoryId}")
	public ResponseEntity<Category> updateCategory(@PathVariable long categoryId, @RequestBody Category category) {
		Category updatedCategory = categoryService.saveCategory(category);
		System.out.println("updated category on Put Request: "+ updatedCategory);
		return new ResponseEntity<Category>(updatedCategory, HttpStatus.OK);
	}
	
	@PostMapping(path= "/addCategory")
	public ResponseEntity<Void> addCategory(@RequestBody Category category) {
		Category newCategory = categoryService.saveCategory(category);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newCategory.getCategoryId()).toUri();
		System.out.println("New Category added on Post Request: "+newCategory);
		return ResponseEntity.created(uri).build();
	}
	
	@CrossOrigin(origins = {"http://localhost:4200","http://localhost:4201"})
	@RequestMapping(value = "/category/{categoryId}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCategory(
			@PathVariable long categoryId) {
		Category category = (Category) categoryService.deleteById(categoryId);
		
			if(category !=null) {
				return ResponseEntity.noContent().build();
			}
		return ResponseEntity.notFound().build();
	}

}
