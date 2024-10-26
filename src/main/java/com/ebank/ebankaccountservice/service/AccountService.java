package com.ebank.ebankaccountservice.service;

import com.ebank.ebankaccountservice.dto.BankAccountRequestDTO;
import com.ebank.ebankaccountservice.dto.BankAccountResponseDTO;

public interface AccountService  {

     BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountDTO);

    BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountDTO);
}
