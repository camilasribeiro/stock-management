package com.mini.market.stock_management.adapters.database;

import com.mini.market.stock_management.domain.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataSaleRepository extends JpaRepository<Sale, Long> {
}