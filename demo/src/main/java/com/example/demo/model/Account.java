package com.example.demo.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.regex.Pattern;
import java.util.Objects;

public class Account {
    private static final Pattern ACCOUNT_NO_PATTERN=Pattern.compile("\\d{8}");

    private String accountNo;
    private LocalDateTime accountOpeningDate;
    private BigDecimal balance;
    
    private Client client;

    public Account(Client client,String accountNo) {
        this.accountOpeningDate=LocalDateTime.now();
        this.balance=BigDecimal.ZERO;
        this.client=Objects.requireNonNull(client,"Client required");
        if (accountNo==null) throw new IllegalArgumentException("Account No required");
        String cleaned=accountNo.trim();
        if (!ACCOUNT_NO_PATTERN.matcher(cleaned).matches()) throw new IllegalArgumentException("Account No must be 8 digits");
        this.accountNo = cleaned;
    }
    public String getAccountNo() {return accountNo;}
    public LocalDateTime getAccountOpeningDate() {return accountOpeningDate;}
    public BigDecimal getBalance() {return balance;}
    public Client getClient() {return client;}

    // Mutations via intent-only methods
    public void deposit(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be > 0");
        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0)
            throw new IllegalArgumentException("Amount must be > 0");
        if (balance.compareTo(amount) < 0)
            throw new IllegalArgumentException("Insufficient balance");
        balance = balance.subtract(amount);
    }

    // Equality by unique accountNo
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account a)) return false;
        return accountNo.equals(a.accountNo);
    }
    @Override public int hashCode() { return accountNo.hashCode(); }







    
}
