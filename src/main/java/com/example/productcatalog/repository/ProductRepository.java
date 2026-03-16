package com.example.productcatalog.repository;

import com.example.productcatalog.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.*;

public interface ProductRepository extends JpaRepository<Product, Long> {

    Page<Product> findByBrandContainingIgnoreCaseAndCategoryContainingIgnoreCase(
            String brand,
            String category,
            Pageable pageable);

}