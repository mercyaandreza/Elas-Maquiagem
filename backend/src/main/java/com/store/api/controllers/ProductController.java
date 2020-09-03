package com.store.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.api.models.Product;
import com.store.api.repositories.ProductRepository;

@RestController
@RequestMapping("/products")
public class ProductController {
// tela do admin
	@Autowired
	private ProductRepository productRepository;
	

	@PostMapping("/create")
	public ResponseEntity <List <Product>> createProduct(@RequestBody List<Product> product) {
		try {
			product = productRepository.saveAll(product);
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Product> updtateProduct (@PathVariable String id,  @RequestBody Product product){
		try {
			Optional<Product> find = productRepository.findById(id);
			Product productFind = find.get();
			
			productFind.setNameProduct(product.getNameProduct());
			productFind.setPriceProduct(product.getPriceProduct());
			productFind.setQuantiteProduct(productFind.getQuantiteProduct());
			
			product = productRepository.save(productFind);
			return new ResponseEntity<>(product, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
		}
		
	}
	
	@DeleteMapping ("/delete/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable String id){
		try {
			productRepository.deleteById(id);
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping ("/deleteAll")
	public ResponseEntity<Product> deleteAllProduct(){
		try {
			productRepository.deleteAll();
			return new ResponseEntity<>(null, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/listAll")
	public ResponseEntity <List <Product>> listAllProducts(){
		try {
			List <Product> product = productRepository.findAll();
			return new ResponseEntity<>(product, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
	
	@GetMapping("/listById/{id}")
	public ResponseEntity <Optional <Product>> listById(@PathVariable String id) {
		try {
			Optional<Product> product = productRepository.findById(id);
			return new ResponseEntity<>(product, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}
	
		
	
}
