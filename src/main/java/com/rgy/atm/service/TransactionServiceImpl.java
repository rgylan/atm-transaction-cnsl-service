package com.rgy.atm.service;

import com.rgy.atm.client.AccountAppClient;
import com.rgy.atm.client.CustomerAppClient;
import com.rgy.atm.dto.AccountDTO;
import com.rgy.atm.dto.CustomerDTO;
import com.rgy.atm.dto.TransactionDTO;
import com.rgy.atm.entity.TransactionEntity;
import com.rgy.atm.repository.TransactionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {

    private final CustomerAppClient customerAppClient;
    private final AccountAppClient accountAppClient;
    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionServiceImpl(CustomerAppClient customerAppClient,
                                  AccountAppClient accountAppClient,
                                  TransactionRepository transactionRepository) {
        this.customerAppClient = customerAppClient;
        this.accountAppClient = accountAppClient;
        this.transactionRepository = transactionRepository;
    }

    @Override
    @Transactional
    public String withdraw(TransactionDTO transactionDTO) throws Exception {
        validateCustomer(transactionDTO);
        AccountDTO account = validateAccount(transactionDTO);

        TransactionEntity entity = new TransactionEntity();
        BeanUtils.copyProperties(transactionDTO, entity);
        entity.setReceipt(UUID.randomUUID().toString());

        transactionRepository.save(entity);
        float balance = account.getBalance() - transactionDTO.getAmount();
        account.setBalance(balance);

        accountAppClient.saveAccount(account);

        return entity.getReceipt();
    }

    @Override
    public void deposit(TransactionDTO transactionDTO) {

    }

    private void validateCustomer(TransactionDTO transactionDTO) throws Exception {
        CustomerDTO customer = customerAppClient.getCustomer(transactionDTO.getCustomerId());
        if (customer == null) {
            throw new Exception("Invalid customer given!");
        }
    }

    private AccountDTO validateAccount(TransactionDTO transactionDTO) throws Exception {
        AccountDTO account = accountAppClient.getAccount(transactionDTO.getAccountId());
        if (account == null) {
            throw new Exception("Invalid account given!");
        }
        return account;
    }
}
