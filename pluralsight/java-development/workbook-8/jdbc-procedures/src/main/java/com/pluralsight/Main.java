package com.pluralsight;

import com.pluralsight.db.DataManager;
import com.pluralsight.models.CustomerOrderHistory;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        DataManager dataManager = new DataManager("jdbc:mysql://localhost:3306/northwind", "root", "P@ssw0rd");

        System.out.println("Enter a customer ID: ");
        String customerID = scanner.nextLine();

        List<CustomerOrderHistory> orderHistoryList = dataManager.searchCustomerOrderHistory(customerID);

        System.out.println("Customer Order History:");
        for (CustomerOrderHistory orderHistory : orderHistoryList) {
            System.out.println("Product Name: " + orderHistory.getProductName()
                    + ", Total Quantity: " + orderHistory.getTotalQuantity());
        }

    }
}
