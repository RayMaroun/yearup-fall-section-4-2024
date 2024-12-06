package com.pluralsight.ledger4.dao.impl;

import com.pluralsight.ledger4.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledger4.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


public class SimpleTransactionDAO implements ITransactionDAO {
    private List<Transaction> transactions;

    public SimpleTransactionDAO() {
        this.transactions = new ArrayList<>();
        // Add some initial transactions
        transactions.add(new Transaction(1, 150.75, "Amazon"));
        transactions.add(new Transaction(2, 89.99, "Walmart"));
        transactions.add(new Transaction(3, 200.00, "Best Buy"));
    }

    @Override
    public Transaction add(Transaction transaction) {
        int maxId = 0;
        for (Transaction t : transactions) {
            if (t.getTransactionId() > maxId) {
                maxId = t.getTransactionId();
            }
        }
        transaction.setTransactionId(maxId + 1); // Increment max ID by 1
        transactions.add(transaction);
        return transaction;
    }

    @Override
    public List<Transaction> getAllTransactions() {
        return transactions;
    }

    @Override
    public Transaction getTransactionById(int transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId() == transactionId) {
                return transaction;
            }
        }
        return null;
    }

    @Override
    public void update(int transactionId, Transaction transaction) {
        int index = getTransactionIndex(transactionId);
        if (index != -1) {
            transactions.set(index, transaction);
        }
    }

    @Override
    public void delete(int transactionId) {
        int index = getTransactionIndex(transactionId);
        if (index != -1) {
            transactions.remove(index);
        }
    }

    private int getTransactionIndex(int transactionId) {
        for (int i = 0; i < transactions.size(); i++) {
            if (transactions.get(i).getTransactionId() == transactionId) {
                return i;
            }
        }
        return -1;
    }
}
