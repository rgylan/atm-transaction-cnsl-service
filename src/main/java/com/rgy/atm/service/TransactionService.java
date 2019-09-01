package com.rgy.atm.service;

import com.rgy.atm.dto.TransactionDTO;

public interface TransactionService {

    /**
     *
     * @param transactionDTO
     * @return
     * @throws Exception
     */
    String withdraw(TransactionDTO transactionDTO) throws Exception;

    /**
     * @param transactionDTO
     * @throws Exception
     */
    void deposit(TransactionDTO transactionDTO) throws Exception;
}
