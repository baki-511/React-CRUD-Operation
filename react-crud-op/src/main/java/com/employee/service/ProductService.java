package com.employee.service;

import com.employee.entity.Product;

import java.util.List;

public interface ProductService {
    public Product saveProduct(Product product);
    
    public List<Product> getAllProducts();
    
    public Product getProductById(Integer id);
    
    public String deleteProduct(Integer id);
    
    public Product updateProduct(Product product);

}
