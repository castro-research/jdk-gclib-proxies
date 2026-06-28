package com.example.demo.banking;

import com.example.demo.account.AccountRepository;

public class BankingTransferServiceImpl implements BankingTransferService, BankingService {
    public final AccountRepository accountRepository;

    public BankingTransferServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void pay() {
        System.out.println("[BankingTransferServiceImpl] pay");
    }

    @Override
    public void transfer() {
        System.out.println("[BankingTransferServiceImpl] transfer");
    }
}
