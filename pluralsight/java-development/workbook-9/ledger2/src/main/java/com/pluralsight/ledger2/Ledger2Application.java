package com.pluralsight.ledger2;

import com.pluralsight.ledger2.models.Transaction;
import com.pluralsight.ledger2.services.TransactionService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Ledger2Application {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Ledger2Application.class, args);
        TransactionService transactionService = context.getBean(TransactionService.class);

        Scanner scanner = new Scanner(System.in); // Scanner for reading user input.
        int choice;
        do {
            // Displaying the menu options to the user.
            System.out.println("========== Ledger Application ==========");
            System.out.println("1. List Transactions");
            System.out.println("2. Add Transaction");
            System.out.println("3. Update Transaction");
            System.out.println("4. Delete Transaction");
            System.out.println("5. Search Transaction");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consumes the newline character after the integer input.

            // Handling user's choice with switch-case.
            switch (choice) {
                case 1:
                    listTransactions(transactionService);
                    break;
                case 2:
                    addTransaction(scanner, transactionService);
                    break;
                case 3:
                    updateTransaction(scanner, transactionService);
                    break;
                case 4:
                    deleteTransaction(scanner, transactionService);
                    break;
                case 5:
                    searchTransaction(scanner, transactionService);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0); // Repeat until user chooses to exit.

        scanner.close(); // Closing the scanner resource.
    }

    private static void listTransactions(TransactionService transactionService) {
        // This method retrieves and displays a list of all transactions.
        System.out.println("========== List of Transactions ==========");
        List<Transaction> transactions = transactionService.getAllTransactions();
        for (Transaction transaction : transactions) {
            System.out.println(transaction); // Prints each transaction.
        }
        System.out.println(); // Adds an empty line for better readability.
    }

    private static void addTransaction(Scanner scanner, TransactionService transactionService) {
        // This method adds a new transaction based on user input.
        System.out.print("Enter transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consumes the newline character.
        System.out.print("Enter vendor name: ");
        String vendor = scanner.nextLine();

        Transaction transaction = new Transaction(amount, vendor);
        Transaction newTransaction = transactionService.addTransaction(transaction); // Adds the transaction to the service.

        System.out.println("Transaction added successfully.\n");
        System.out.println(newTransaction);
        System.out.println();
    }

    private static void updateTransaction(Scanner scanner, TransactionService transactionService) {
        // This method updates an existing transaction based on user input.
        System.out.print("Enter the transaction ID to update: ");
        int transactionId = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character.

        Transaction existingTransaction = transactionService.getTransactionById(transactionId);
        if (existingTransaction == null) {
            System.out.println("Transaction not found.\n");
            return;
        }

        System.out.print("Enter new transaction amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consumes the newline character.
        System.out.print("Enter new vendor name: ");
        String vendor = scanner.nextLine();

        Transaction updatedTransaction = new Transaction(transactionId, amount, vendor);
        transactionService.updateTransaction(transactionId, updatedTransaction); // Updates the transaction.

        System.out.println("Transaction updated successfully.\n");
    }

    private static void deleteTransaction(Scanner scanner, TransactionService transactionService) {
        // This method deletes a transaction based on the transaction ID provided by the user.
        System.out.print("Enter the transaction ID to delete: ");
        int transactionId = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character.

        Transaction existingTransaction = transactionService.getTransactionById(transactionId);
        if (existingTransaction == null) {
            System.out.println("Transaction not found.\n");
            return;
        }

        transactionService.deleteTransaction(transactionId); // Deletes the transaction.

        System.out.println("Transaction deleted successfully.\n");
    }

    private static void searchTransaction(Scanner scanner, TransactionService transactionService) {
        // This method searches for a transaction based on the transaction ID provided by the user.
        System.out.print("Enter the transaction ID to search: ");
        int transactionId = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline character.

        Transaction transaction = transactionService.getTransactionById(transactionId);
        if (transaction == null) {
            System.out.println("Transaction not found.\n");
        } else {
            System.out.println("========== Transaction Details ==========");
            System.out.println(transaction); // Displays the details of the found transaction.
            System.out.println();
        }
    }

}
