package com.pluralsight.ledgerapi6.dao.interfaces;

import com.pluralsight.ledgerapi6.models.Transaction;

import java.util.List;

/**
 * Interface for Data Access Object (DAO) operations related to the Transaction model.
 * This interface defines the standard operations to be performed on the Transaction data.
 */
public interface ITransactionDAO {

    /**
     * Retrieves all transactions from the data store.
     *
     * @return A list of all transactions.
     */
    List<Transaction> getAllTransactions();

    /**
     * Retrieves a specific transaction by its ID.
     *
     * @param transactionId The ID of the transaction to retrieve.
     * @return The Transaction object if found, or null otherwise.
     */
    Transaction getTransactionById(int transactionId);

    /**
     * Adds a new transaction to the data store.
     *
     * @param transaction The Transaction object to be added.
     * @return the new transaction
     */
    Transaction add(Transaction transaction);

    /**
     * Updates an existing transaction in the data store.
     *
     * @param transactionId The ID of the transaction to update.
     * @param transaction The Transaction object with updated information.
     */
    void update(int transactionId, Transaction transaction);

    /**
     * Deletes a transaction from the data store.
     *
     * @param transactionId The ID of the transaction to delete.
     */
    void delete(int transactionId);

}
