package com.rgy.atm.dto;

import java.io.Serializable;
import java.util.Objects;

public class AccountDTO implements Serializable {

    private Long id;
    private Long customerId;
    private String accountType;
    private Float balance;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountDTO that = (AccountDTO) o;
        return id.equals(that.id) &&
                customerId.equals(that.customerId) &&
                accountType.equals(that.accountType) &&
                balance.equals(that.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, accountType, balance);
    }

    @Override
    public String toString() {
        return "AccountDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", accountType='" + accountType + '\'' +
                ", balance=" + balance +
                '}';
    }
}
