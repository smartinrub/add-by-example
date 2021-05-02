package com.sergiomartinrubio.tddbyexample.repository;

import com.sergiomartinrubio.tddbyexample.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TransactionRepository extends JpaRepository<Transaction, UUID> {
}
