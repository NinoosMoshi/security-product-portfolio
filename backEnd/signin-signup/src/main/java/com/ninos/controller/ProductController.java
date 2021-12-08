package com.ninos.controller;

import com.ninos.model.Product;
import com.ninos.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // http://localhost:8080/api/all
    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProduct();
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }



    // http://localhost:8080/api/add
    @PostMapping("/add")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        Product products = productService.addProduct(product);
        return new ResponseEntity<Product>(products, HttpStatus.CREATED);
    }


    // http://localhost:8080/api/update
    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<Product>(updateProduct, HttpStatus.OK);
    }


    // http://localhost:8080/api/find/{value}
    @GetMapping("/find/{id}")
    public ResponseEntity<Product> findProduct(@PathVariable("id") Long id){
        Product findProduct = productService.findProductById(id);
        return new ResponseEntity<Product>(findProduct,HttpStatus.OK);
    }


    // http://localhost:8080/api/delete/{value}
    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable("id") Long id){
        productService.deleteProduct(id);
    }

}
