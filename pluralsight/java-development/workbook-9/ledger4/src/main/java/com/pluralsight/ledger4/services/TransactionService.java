package com.pluralsight.ledger4.services;

import com.pluralsight.ledger4.dao.interfaces.ITransactionDAO;
import com.pluralsight.ledger4.models.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * TransactionService provides a layer of abstraction between the controller and the data access object (DAO).
 * It contains the business logic to interact with transactions and uses the ITransactionDAO for database operations.
 */
@Component
// Indicates that this class is a Spring component. It will be automatically detected and instantiated by Spring.
public class TransactionService {
    private ITransactionDAO transactionDAO; // Interface to data access object for transactions.

    /**
     * Autowired constructor for dependency injection.
     * Spring will inject an implementation of ITransactionDAO when TransactionService is created.
     *
     * @param transactionDAO the DAO implementation to be used by this service.
     */
    @Autowired // Injects the transactionDAO implementation.
    public TransactionService(ITransactionDAO transactionDAO) {
        this.transactionDAO = transactionDAO;
    }

    /**
     * Adds a new transaction.
     *
     * @param transaction the transaction to add.
     * @return the new transaction
     */
    public Transaction addTransaction(Transaction transaction) {
        return transactionDAO.add(transaction);
    }

    /**
     * Retrieves all transactions.
     *
     * @return a list of all transactions.
     */
    public List<Transaction> getAllTransactions() {
        return transactionDAO.getAllTransactions();
    }

    /**
     * Retrieves a transaction by its ID.
     *
     * @param transactionId the ID of the transaction.
     * @return the transaction with the specified ID, or null if not found.
     */
    public Transaction getTransactionById(int transactionId) {
        return transactionDAO.getTransactionById(transactionId);
    }

    /**
     * Updates an existing transaction.
     *
     * @param transaction the transaction with updated details.
     */
    public void updateTransaction(int transactionId, Transaction transaction) {
        transactionDAO.update(transactionId, transaction);
    }

    /**
     * Deletes a transaction.
     *
     * @param transactionId The ID of the transaction to delete.
     */
    public void deleteTransaction(int transactionId) {
        transactionDAO.delete(transactionId);
    }
}
