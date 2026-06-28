package com.example.demo.transfer;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
class TransferServiceImpl implements TransferService {

    @Override
    @Transactional
    public void pay() {
        System.out.println("Efetuando Transferencia");
    }
}