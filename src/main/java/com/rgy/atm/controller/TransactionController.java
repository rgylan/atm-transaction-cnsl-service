package com.rgy.atm.controller;

import com.rgy.atm.dto.TransactionDTO;
import com.rgy.atm.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/transactions")
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @PostMapping(path = "/withdraw", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> withdraw(@RequestBody TransactionDTO dto) throws Exception {
        return new ResponseEntity<>(transactionService.withdraw(dto), HttpStatus.OK);
    }
}
