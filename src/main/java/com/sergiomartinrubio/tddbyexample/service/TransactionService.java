package com.sergiomartinrubio.tddbyexample.service;

import com.sergiomartinrubio.tddbyexample.exception.AccountNotFoundException;
import com.sergiomartinrubio.tddbyexample.model.Account;
import com.sergiomartinrubio.tddbyexample.model.Transaction;
import com.sergiomartinrubio.tddbyexample.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransactionService {

    private final AccountService accountService;
    private final TransactionRepository transactionRepository;

    public TransactionService(AccountService accountService, TransactionRepository transactionRepository) {
        this.accountService = accountService;
        this.transactionRepository = transactionRepository;
    }

    public void save(Transaction transaction) {
        Optional<Account> account = accountService.findById(transaction.getIbanNumber());

        if (account.isEmpty()) {
            throw new AccountNotFoundException();
        }

        transactionRepository.save(transaction);
    }
}
