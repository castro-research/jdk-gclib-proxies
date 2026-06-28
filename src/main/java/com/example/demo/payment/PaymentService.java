package com.example.demo.payment;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentService {
    @Transactional
    public void pay() {
        System.out.println("Efetuando Transferencia");
    }
}