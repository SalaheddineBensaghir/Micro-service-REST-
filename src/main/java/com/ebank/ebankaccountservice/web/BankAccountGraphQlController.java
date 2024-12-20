package com.ebank.ebankaccountservice.web;

import com.ebank.ebankaccountservice.dto.BankAccountRequestDTO;
import com.ebank.ebankaccountservice.dto.BankAccountResponseDTO;
import com.ebank.ebankaccountservice.entites.BankAccount;
import com.ebank.ebankaccountservice.repositories.BankAccountRepository;
import com.ebank.ebankaccountservice.service.AccountService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class BankAccountGraphQlController {
    @Autowired
    private BankAccountRepository bankAccountRepository;
    @Autowired
    private AccountService accountService;
    @QueryMapping
    public List<BankAccount> accountsList(){
        return bankAccountRepository.findAll();
    }
    @QueryMapping
    public BankAccount bankAccountById(@Argument String id){
        return bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("Account %s not found",id)));
    }
@MutationMapping
    public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccount){

        return accountService.addAccount(bankAccount);
    }

    @MutationMapping
    public BankAccountResponseDTO updateAccount(@Argument String id,@Argument BankAccountRequestDTO bankAccount){

        return accountService.updateAccount(id,bankAccount);
    }
    @MutationMapping
    public boolean deleteAccount(@Argument String id){

    bankAccountRepository.deleteById(id);
    return true;
    }
}
//record BankAccountDTO(Double balance,String type,String currency){
//
//}

//@Data
//@NoArgsConstructor @AllArgsConstructor
//class BankAccountDTO {
//
//    private String type;
//    private Double balance;
//    private String currency;
//}
