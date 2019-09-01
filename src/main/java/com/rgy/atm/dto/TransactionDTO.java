package com.rgy.atm.dto;

import java.io.Serializable;
import java.util.Objects;

public class TransactionDTO implements Serializable {

    private Long customerId;
    private Long accountId;
    private String transactionType;
    private Float amount;

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TransactionDTO that = (TransactionDTO) o;
        return customerId.equals(that.customerId) &&
                accountId.equals(that.accountId) &&
                transactionType.equals(that.transactionType) &&
                amount.equals(that.amount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, accountId, transactionType, amount);
    }

    @Override
    public String toString() {
        return "TransactionDTO{" +
                "customerId=" + customerId +
                ", accountId=" + accountId +
                ", transactionType='" + transactionType + '\'' +
                ", ammout=" + amount +
                '}';
    }
}
