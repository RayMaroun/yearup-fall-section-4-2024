package com.pluralsight.ledgerapi3.dao.interfaces;

import com.pluralsight.ledgerapi3.models.Transaction;

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
}
