package com.employee.controller;

import com.employee.entity.Product;
import com.employee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ProductController {
    
    @Autowired
    private ProductService productService;
    
    @PostMapping("/saveProduct")
    public ResponseEntity<?> saveProduct(@RequestBody Product product) {
        System.out.println("Product is Added...");
        return new ResponseEntity<>(productService.saveProduct(product), HttpStatus.CREATED);
    }
    
    @GetMapping("/")
    public ResponseEntity<?> getAllProducts() {
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
    }
    
    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Integer id) {
        return new ResponseEntity<>(productService.deleteProduct(id), HttpStatus.OK);
    }
    
    @PutMapping("/editProduct")
    public ResponseEntity<?> editProduct(@RequestBody Product product) {
        System.out.println("Method is Called");
        return new ResponseEntity<>(productService.updateProduct(product), HttpStatus.CREATED);
    }

}
