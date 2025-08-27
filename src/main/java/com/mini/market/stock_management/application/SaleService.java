package com.mini.market.stock_management.application;

import com.mini.market.stock_management.domain.Product;
import com.mini.market.stock_management.domain.Sale;
import com.mini.market.stock_management.domain.repository.ProductRepository;
import com.mini.market.stock_management.domain.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ProductRepository productRepository;

    public Sale createSale(Long productId, Integer quantidade) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        if (!"Ativo".equalsIgnoreCase(product.getStatus())) {
            throw new RuntimeException("Produto inativo não pode ser vendido");
        }

        if (product.getQuantidade() < quantidade) {
            throw new RuntimeException("Quantidade em estoque é insuficiente");
        }

        product.setQuantidade(product.getQuantidade() - quantidade);
        productRepository.save((product));

        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setQuantidade(quantidade);

        return saleRepository.save(sale);
    }
}