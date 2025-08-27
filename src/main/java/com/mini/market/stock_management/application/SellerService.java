package com.mini.market.stock_management.application;

import com.mini.market.stock_management.adapters.messaging.WhatsAppService;
import com.mini.market.stock_management.domain.Seller;
import com.mini.market.stock_management.domain.repository.SellerRepository;
import com.mini.market.stock_management.infrastructure.config.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SellerService {

    @Autowired
    private SellerRepository sellerRepository;

    @Autowired
    private WhatsAppService whatsAppService;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Seller createSeller(Seller seller) {
        seller.setAtivo(false);
        seller.setSenha(passwordEncoder.encode(seller.getSenha()));

        String codigo = whatsAppService.generateActivationCode();

        try {
            whatsAppService.sendActivationCode(seller.getCelular(), codigo);
        } catch (Exception e) {
            throw new RuntimeException("Falha ao enviar código de ativação: " + e);
        }

        seller.setCodigoAtivacao(codigo);
        return sellerRepository.save(seller);
    }

    public Seller activateSeller(String celular, String codigo) {
        Seller seller = sellerRepository.findByCelular(celular)
                .orElseThrow(() -> new RuntimeException("Seller não encontrado."));

        if (!codigo.equalsIgnoreCase(seller.getCodigoAtivacao())) {
            throw new RuntimeException("Código inválido");
        }

        seller.setAtivo(true);
        seller.setCodigoAtivacao(null);
        return sellerRepository.save(seller);
    }

    public String login(String email, String senha) {
        Seller seller = sellerRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Email não encontrado"));

        if (!passwordEncoder.matches(senha, seller.getSenha())) {
            throw new RuntimeException("Senha incorreta");
        }

        if (!seller.isAtivo()) {
            throw new RuntimeException("Seller não ativado");
        }

        return jwtUtil.generateToken(email);
    }
}