package com.sergiomartinrubio.tddbyexample.service;

import com.sergiomartinrubio.tddbyexample.exception.AccountNotFoundException;
import com.sergiomartinrubio.tddbyexample.model.Account;
import com.sergiomartinrubio.tddbyexample.model.Transaction;
import com.sergiomartinrubio.tddbyexample.repository.TransactionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    private static final String IBAN = "1234";
    @Mock
    private AccountService accountService;

    @Mock
    private TransactionRepository transactionRepository;

    @InjectMocks
    private TransactionService transactionService;

    @Test
    void givenTransactionWhenSaveTransactionThenCallRepositoryToSaveTransaction() {
        // GIVEN
        Transaction transaction = new Transaction(UUID.randomUUID(), IBAN, 100.0);
        Account account = new Account();
        when(accountService.findById(IBAN)).thenReturn(Optional.of(account));

        // WHEN
        transactionService.save(transaction);

        // THEN
        verify(transactionRepository).save(transaction);
    }

    @Test
    void givenTransactionThatDoesNotMatchWithAnAccountWhenSaveTransactionThenThrowAccountNotFoundException() {
        // GIVEN
        Transaction transaction = new Transaction(UUID.randomUUID(), IBAN, 100.0);
        when(accountService.findById(IBAN)).thenReturn(Optional.empty());

        // WHEN
        assertThatThrownBy(() -> transactionService.save(transaction))
                .isInstanceOf(AccountNotFoundException.class);

        // THEN
        verifyNoInteractions(transactionRepository);
    }

}
