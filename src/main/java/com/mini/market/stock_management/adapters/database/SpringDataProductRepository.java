package com.mini.market.stock_management.adapters.database;

import com.mini.market.stock_management.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataProductRepository extends JpaRepository<Product, Long> {
}