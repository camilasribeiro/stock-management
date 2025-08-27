package com.mini.market.stock_management.adapters.database;

import com.mini.market.stock_management.domain.Product;
import com.mini.market.stock_management.domain.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class ProductAdapter implements ProductRepository {

    @Autowired
    private SpringDataProductRepository springDataProductRepository;


    @Override
    public Product save(Product product) {
        return springDataProductRepository.save(product);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return springDataProductRepository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return springDataProductRepository.findAll();
    }
}