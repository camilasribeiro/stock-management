package com.mini.market.stock_management.domain.repository;

import com.mini.market.stock_management.domain.Sale;
import java.util.List;
import java.util.Optional;

public interface SaleRepository {
    Sale save(Sale sale);
    Optional<Sale> findById(Long id);
    List<Sale> findAll();
}