package com.example.demo;

import com.example.demo.account.AccountRepository;
import com.example.demo.banking.BankingClient;
import com.example.demo.banking.BankingService;
import com.example.demo.banking.BankingTransferService;
import com.example.demo.banking.BankingTransferServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.support.DefaultTransactionStatus;

@Configuration
@EnableTransactionManagement
public class AppConfig {

    @Bean
    public BankingClient bankingService(BankingService svc) {
        return new BankingClient(svc);
    }

    // Aqui vai dar erro, por que o spring não conhece o BankingService, mesmo que esteja em BankingTransferServiceImpl
//    org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'bankingService' defined
//    @Bean
//    public BankingTransferService transferService(AccountRepository repo) {
//        return new BankingTransferServiceImpl(repo);
//    }

    // 1 solução
//    @Bean
//    public BankingTransferServiceImpl transferService(AccountRepository repo) {
//        return new BankingTransferServiceImpl(repo);
//    }

    // ou 2, retornar o BankingService
    @Bean
    public BankingService transferService(AccountRepository repo) {
        return new BankingTransferServiceImpl(repo);
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        return new AbstractPlatformTransactionManager() {
            @Override
            protected Object doGetTransaction() {
                return new Object();
            }

            @Override
            protected void doBegin(Object transaction, TransactionDefinition definition) {
            }

            @Override
            protected void doCommit(DefaultTransactionStatus status) {
            }

            @Override
            protected void doRollback(DefaultTransactionStatus status) {
            }
        };
    }
}
