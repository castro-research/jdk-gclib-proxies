package com.example.demo;

import com.example.demo.banking.BankingClient;
import com.example.demo.banking.BankingTransferService;
import com.example.demo.payment.PaymentService;
import com.example.demo.transfer.TransferService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main
{
    public static void main(String[] args)
    {
        var context = new AnnotationConfigApplicationContext("com.example.demo");
        TransferService service = context.getBean(TransferService.class);

        //class com.example.demo.transfer.TransferServiceImpl
        System.out.println(service.getClass());
        //com.example.demo.transfer.TransferServiceImpl@79d8407f
        System.out.println(service);
        service.pay();

        PaymentService pservice = context.getBean(PaymentService.class);

        //class com.example.demo.transfer.TransferServiceImpl
        System.out.println(pservice.getClass());
        //com.example.demo.transfer.TransferServiceImpl@79d8407f
        System.out.println(pservice);

        service.pay();

        // Ultimo exemplo
        // Baseado em: Bean Creation Order and Injection Issues
        // https://spring.academy/courses/spring-framework-essentials/lessons/spring-essentials-spring-container-bean-creation-injection-issues
        BankingTransferService bankTransferService = context.getBean(BankingTransferService.class);
        bankTransferService.pay();

        context.close();
    }
}