package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID; //universally unique identifier 

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Transaction {

    public enum Type {DEPOSIT,WITHDRAW}

    private final String id;
    private final Account account;
    private final Type type;
    private final BigDecimal amount;
    private final BigDecimal resultingBalance;
    private final LocalDateTime timestamp;

    public Transaction(Account account, Type type,BigDecimal amount, BigDecimal resultingBalance ) {

        if (account == null) throw new IllegalArgumentException("Account required");
        if (type == null) throw new IllegalArgumentException("Type required");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be > 0");
        if (resultingBalance == null || resultingBalance.compareTo(BigDecimal.ZERO) < 0)
            throw new IllegalArgumentException("Invalid resulting balance");

        this.id = UUID.randomUUID().toString();
        this.account = account;
        this.type = type;
        this.amount = amount;
        this.resultingBalance = resultingBalance;
        this.timestamp = LocalDateTime.now();

    }
    public String getId() { return id; }
    @JsonIgnore
    public Account getAccount() { return account; }
    public Type getType() { return type; }
    public BigDecimal getAmount() { return amount; }
    public BigDecimal getResultingBalance() { return resultingBalance; }
    public LocalDateTime getTimestamp() { return timestamp; }




    
}
