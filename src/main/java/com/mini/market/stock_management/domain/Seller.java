package com.mini.market.stock_management.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cnpj;
    private String email;
    private String celular;
    private String senha;

    private boolean ativo;
    private String codigoAtivacao;
}