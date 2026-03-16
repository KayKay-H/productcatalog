package com.example.productcatalog.service;

import com.example.productcatalog.model.Product;
import com.example.productcatalog.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repo;

    public Product save(Product product) {
        return repo.save(product);
    }

    public Page<Product> getProducts(String brand, String category, int page, String sortField) {

        Pageable pageable = PageRequest.of(page, 5, Sort.by(sortField));

        return repo.findByBrandContainingIgnoreCaseAndCategoryContainingIgnoreCase(
                brand, category, pageable);
    }
}