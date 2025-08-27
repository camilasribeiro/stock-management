package com.mini.market.stock_management.web;

import lombok.Data;

@Data
public class LoginRequest {
    private String email;
    private String senha;
}