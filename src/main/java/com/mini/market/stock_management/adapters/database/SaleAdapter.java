package com.mini.market.stock_management.adapters.database;

import com.mini.market.stock_management.domain.Sale;
import com.mini.market.stock_management.domain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SaleAdapter implements SaleRepository {

    @Autowired
    private SpringDataSaleRepository springDataSaleRepository;

    @Override
    public Sale save(Sale sale) {
        return springDataSaleRepository.save(sale);
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return springDataSaleRepository.findById(id);
    }

    @Override
    public List<Sale> findAll() {
        return springDataSaleRepository.findAll();
    }
}