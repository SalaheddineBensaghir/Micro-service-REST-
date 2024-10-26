package com.ebank.ebankaccountservice.service;

import com.ebank.ebankaccountservice.dto.BankAccountRequestDTO;
import com.ebank.ebankaccountservice.dto.BankAccountResponseDTO;
import com.ebank.ebankaccountservice.entites.BankAccount;
import com.ebank.ebankaccountservice.mappers.AccountMapper;
import com.ebank.ebankaccountservice.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
   @Autowired
    private BankAccountRepository bankAccountRepository;
  @Autowired
   private AccountMapper accountMapper;
   @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO) {
        BankAccount bankAccount =BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(bankAccountDTO.getBalance())
                .type(bankAccountDTO.getType())
                .currency(bankAccountDTO.getCurrency())
                .build();
        BankAccount saveBankAccount = bankAccountRepository.save(bankAccount);
//        BankAccountResponseDTO bankAccountResponseDTO= BankAccountResponseDTO.builder()
//                .id(saveBankAccount.getId())
//                .type(saveBankAccount.getType())
//                .createdAt(saveBankAccount.getCreatedAt())
//                .currency(saveBankAccount.getCurrency())
//                .balance(saveBankAccount.getBalance())
//                .build();
       BankAccountResponseDTO bankAccountResponseDTO = accountMapper.fromResponseDTO(saveBankAccount);
       return bankAccountResponseDTO;
    }
}
