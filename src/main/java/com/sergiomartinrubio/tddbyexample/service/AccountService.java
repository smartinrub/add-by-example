package com.sergiomartinrubio.tddbyexample.service;

import com.sergiomartinrubio.tddbyexample.model.Account;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AccountService {
    public Optional<Account> findById(String iban) {
        return Optional.empty();
    }
}
