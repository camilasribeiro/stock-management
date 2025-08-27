package com.mini.market.stock_management.adapters.messaging;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class WhatsAppService {

    @Value("${twilio.account.sid}")
    private String accountSid;

    @Value("${twilio.auth.token}")
    private String authToken;

    @Value("${twilio.whatsapp.from}")
    private String fromWhatsAppNumber;

    public void initTwilio() {
        Twilio.init(accountSid, authToken);
    }

    public String generateActivationCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }

    public void sendActivationCode(String toCelular, String code) {
        initTwilio();

        try {
            Message.creator(
                    new PhoneNumber("whatsapp:" + toCelular),
                    new PhoneNumber("whatsapp:" + fromWhatsAppNumber),
                    "Seu código de ativação é: " + code
            ).create();
        } catch (com.twilio.exception.ApiException e) {
            if (e.getStatusCode() == 403) {
                throw new RuntimeException("Não foi possível enviar WhatsApp. Verifique se o número está correto.");
            } else {
                throw new RuntimeException("Erro ao enviar WhatsApp: " + e.getMessage());
            }
        }
    }
}