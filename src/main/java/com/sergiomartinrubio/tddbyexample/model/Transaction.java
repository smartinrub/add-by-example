package com.sergiomartinrubio.tddbyexample.model;

import java.util.Objects;
import java.util.UUID;

public class Transaction {

    private UUID id;
    private String ibanNumber;
    private Double amount;

    public Transaction(UUID id, String ibanNumber, Double amount) {
        this.id = id;
        this.ibanNumber = ibanNumber;
        this.amount = amount;
    }

    public Transaction() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getIbanNumber() {
        return ibanNumber;
    }

    public void setIbanNumber(String ibanNumber) {
        this.ibanNumber = ibanNumber;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transaction that = (Transaction) o;
        return Objects.equals(id, that.id) && Objects.equals(ibanNumber, that.ibanNumber) && Objects.equals(amount, that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ibanNumber, amount);
    }
}
