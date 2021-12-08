package com.ninos.service;

import com.ninos.model.Product;

import java.util.List;

public interface ProductService {

    public Product addProduct(Product product);

    public List<Product> findAllProduct();

    public Product updateProduct(Product product);

    public Product findProductById(Long id);

    public void deleteProduct(Long id);

}
