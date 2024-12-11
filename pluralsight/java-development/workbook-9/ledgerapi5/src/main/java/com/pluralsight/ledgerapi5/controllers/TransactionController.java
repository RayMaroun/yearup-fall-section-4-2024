package com.pluralsight.ledgerapi5.controllers;

import com.pluralsight.ledgerapi5.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledgerapi5.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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

    @RequestMapping(path = "/transactions", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Transaction addTransaction(@RequestBody Transaction transaction) {
        return transactionDAO.add(transaction);
    }

    @RequestMapping(path = "/transactions/{transactionId}", method = RequestMethod.PUT)
    public void updateTransaction(@PathVariable int transactionId, @RequestBody Transaction transaction) {
        transactionDAO.update(transactionId, transaction);
    }
}
