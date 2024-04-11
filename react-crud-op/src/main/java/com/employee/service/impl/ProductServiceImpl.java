package com.employee.service.impl;

import com.employee.entity.Product;
import com.employee.repository.ProductRepository;
import com.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }
    
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    
    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product with Id " + id + " NOT Found"));
    }
    
    @Override
    public String deleteProduct(Integer id) {
        Product product = getProductById(id);
        if (product != null) {
            productRepository.delete(product);
            return "Product Deleted Successfully";
        }
        return "Something went Wrong on Server";
    }
    
    @Override
    public Product updateProduct(Product product) {
        Product sample = getProductById(product.getId());
        return productRepository.save(product);
        
    }
}
