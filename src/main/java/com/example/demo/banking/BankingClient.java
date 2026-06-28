package com.example.demo.banking;

public class BankingClient {
    private final BankingService bankingService;

    public BankingClient(BankingService bankingService) {
        this.bankingService = bankingService;
    }
}
