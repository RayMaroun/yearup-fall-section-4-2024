package com.pluralsight.ledgerapi3.controllers;

import com.pluralsight.ledgerapi3.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledgerapi3.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {
    private final ITransactionDAO transactionDAO;

    @Autowired
    public TransactionController(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    @RequestMapping(path = "/transactions", method = RequestMethod.GET)
    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    @RequestMapping(path = "/transactions/{transactionId}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable int transactionId) {
        return transactionDAO.getTransactionById(transactionId);
    }
}
