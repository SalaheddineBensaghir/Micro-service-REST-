package com.ebank.ebankaccountservice;

import com.ebank.ebankaccountservice.entites.BankAccount;
import com.ebank.ebankaccountservice.enums.AccountType;
import com.ebank.ebankaccountservice.repositories.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class EbankAccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EbankAccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner star(BankAccountRepository bankAccountRepository){
        return args -> {
for (int i=0;i<10;i++){
    BankAccount bankAccount=BankAccount.builder().id(UUID.randomUUID().toString())
            .type(Math.random()>0.5? AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACCOUNT)
            .balance(1000+Math.random()*9000)
            .createdAt(new Date())
            .currency("MAD")
    .build();
    bankAccountRepository.save(bankAccount);
            }
        };
    }
}
