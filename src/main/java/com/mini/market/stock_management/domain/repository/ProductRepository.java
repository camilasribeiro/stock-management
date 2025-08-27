package com.mini.market.stock_management.domain.repository;

import com.mini.market.stock_management.domain.Product;
import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    Product save(Product product);
    Optional<Product> findById(Long id);
    List<Product> findAll();
}