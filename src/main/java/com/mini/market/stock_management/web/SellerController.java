package com.mini.market.stock_management.web;

import com.mini.market.stock_management.application.SellerService;
import com.mini.market.stock_management.domain.Seller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @PostMapping
    public Seller createSeller(@RequestBody Seller seller) {
        System.out.println("Salvando seller: " + seller.getEmail());
        Seller savedSeller =  sellerService.createSeller(seller);
        System.out.println("Seller saldo: " + seller.getId());
        return savedSeller;
    }

    @PostMapping("/activate")
    public Seller activateSeller(@RequestBody ActivateSellerRequest request) {
        return sellerService.activateSeller(request.getCelular(), request.getCodigo());
    }
}