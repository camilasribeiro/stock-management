package com.mini.market.stock_management.web;

import com.mini.market.stock_management.application.SaleService;
import com.mini.market.stock_management.domain.Sale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @PostMapping
    public Sale createSale(@RequestParam Long productId, @RequestParam Integer quantidade) {
        return saleService.createSale(productId, quantidade);
    }
}