package com.mini.market.stock_management.adapters.database;

import com.mini.market.stock_management.domain.Seller;
import com.mini.market.stock_management.domain.repository.SellerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class SellerAdapter implements SellerRepository{

    @Autowired
    private SpringDataSellerRepository springDataSellerRepository;

    @Override
    public Seller save(Seller seller) {
        return springDataSellerRepository.save(seller);
    }

    @Override
    public List<Seller> findAll() {
        return springDataSellerRepository.findAll();
    }

    @Override
    public Optional<Seller> findByEmail(String email) {
        return springDataSellerRepository.findByEmail(email);
    }

    @Override
    public Optional<Seller> findByCelular(String celular) {
        return springDataSellerRepository.findByCelular(celular);
    }
}
