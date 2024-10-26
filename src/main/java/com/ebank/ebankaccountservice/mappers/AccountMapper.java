package com.ebank.ebankaccountservice.mappers;

import com.ebank.ebankaccountservice.dto.BankAccountResponseDTO;
import com.ebank.ebankaccountservice.entites.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper {
    public BankAccountResponseDTO fromResponseDTO (BankAccount bankAccount){
       BankAccountResponseDTO bankAccountResponseDTO=new BankAccountResponseDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountResponseDTO);
        return bankAccountResponseDTO;
    }
}
