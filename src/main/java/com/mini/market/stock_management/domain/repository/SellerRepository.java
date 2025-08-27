package com.mini.market.stock_management.domain.repository;

import com.mini.market.stock_management.domain.Seller;
import java.util.List;
import java.util.Optional;

public interface SellerRepository {
    Seller save(Seller seller);
    List<Seller> findAll();
    Optional<Seller> findByEmail(String email);
    Optional<Seller> findByCelular(String celular);
}