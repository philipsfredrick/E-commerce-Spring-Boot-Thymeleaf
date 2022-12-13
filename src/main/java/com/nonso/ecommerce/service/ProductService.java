package com.nonso.ecommerce.service;

import com.nonso.ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    void addProduct(Product product);
    void removeProductById(Integer id);
    Optional<Product> getProductById(Integer id);
    List<Product> getAllProductsByCategoryId(Integer id);
}
