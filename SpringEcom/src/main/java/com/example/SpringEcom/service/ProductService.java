package com.example.SpringEcom.service;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.SpringEcom.model.Product;
import com.example.SpringEcom.repo.ProductRepo;
@Service
public class ProductService {
	
	@Autowired
	private ProductRepo repo;

	public List<Product> getAllProducts() {
		return repo.findAll();
	}

	public Product getProductById(int id) {
		return repo.findById(id).orElse(new Product());
	}

	public Product addProduct(Product product, MultipartFile image) throws IOException {
		product.setImageName(image.getOriginalFilename());
		product.setImageType(image.getContentType());
		product.setImageData(image.getBytes());
		return repo.save(product);
	}

	public Product updateProduct(Product product, MultipartFile image) throws IOException {
		product.setImageName(image.getOriginalFilename());
		product.setImageType(image.getContentType());
		product.setImageData(image.getBytes());
		return repo.save(product);
	}

	public String deleteProduct(int id) {
		repo.deleteById(id);
		return "Product Deleted";
	}

	public List<Product> searchProducts(String keyword) {
		return repo.searchProducts(keyword);
	}


}
