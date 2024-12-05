package com.pluralsight.ledger2.dao.impl;

import com.pluralsight.ledger2.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledger2.models.Transaction;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
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
    public void add(Transaction transaction) {
        transactions.add(transaction);
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
    public void update(Transaction transaction) {
        int index = getTransactionIndex(transaction.getTransactionId());
        if (index != -1) {
            transactions.set(index, transaction);
        }
    }

    @Override
    public void delete(Transaction transaction) {
        int index = getTransactionIndex(transaction.getTransactionId());
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
