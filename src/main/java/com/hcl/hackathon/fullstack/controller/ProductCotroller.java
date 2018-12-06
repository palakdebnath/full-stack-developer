package com.hcl.hackathon.fullstack.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.hackathon.fullstack.domain.Product;

@RestController
// @RequestMapping("/products")
public class ProductCotroller {
	
	List<Product> prodList = new ArrayList<Product>();
	
	ProductCotroller() {
		init();
	}
	
	@GetMapping("/products")
	public List<Product> getAllProducts() {
		return prodList;
	}
	
	@GetMapping("/products/{pid}")
	public Product getProduct(@PathVariable int pid) {
		
		Product retProd = prodList.stream().filter(p-> p.getId() == pid).findAny().orElse(null);
		return retProd;
	}
	
	@PostMapping("/products")
	public String saveProduct(@RequestBody Product p) {
		prodList.add(p);
		return "Product added to list...";
	}
	
	@DeleteMapping("/products/{pid}")
	public String deleteProduct(@PathVariable int pid) {
		
		prodList.removeIf(p-> p.getId() == pid);
		return "Producted deleted...";
	}
	
	private void init() {
		prodList.add(new Product(1, "Book", 30.00));
		prodList.add(new Product(2, "Pen", 5.00));
		prodList.add(new Product(3, "Pencil", 3.00));
	}

}
