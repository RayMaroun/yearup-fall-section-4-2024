package com.pluralsight.ledgerapi2.controllers;

import com.pluralsight.ledgerapi2.models.Transaction;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionsController {
    private List<Transaction> transactions;

    public TransactionsController() {
        transactions = new ArrayList<>();
        // Add some initial transactions
        transactions.add(new Transaction(1, 150.75, "Amazon"));
        transactions.add(new Transaction(2, 89.99, "Walmart"));
        transactions.add(new Transaction(3, 200.00, "Best Buy"));
    }

    @RequestMapping(path = "/transactions", method = RequestMethod.GET)
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @RequestMapping(path = "/transactions/{transactionId}", method = RequestMethod.GET)
    public Transaction getTransactionById(@PathVariable int transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId() == transactionId) {
                return transaction;
            }
        }
        return null; // Return null if transaction with given ID is not found
    }
}
