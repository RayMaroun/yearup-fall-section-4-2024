package com.pluralsight.db;

import com.pluralsight.models.CustomerOrderHistory;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    private BasicDataSource dataSource;

    public DataManager(String url, String username, String password) {
        this.dataSource = new BasicDataSource();
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
    }

    public List<CustomerOrderHistory> searchCustomerOrderHistory(String customerId) {
        List<CustomerOrderHistory> orderHistoryList = new ArrayList<>();

        try (Connection connection = dataSource.getConnection();
             CallableStatement statement = connection.prepareCall("{CALL CustOrderHist(?)}")) {
            statement.setString(1, customerId);

            try (ResultSet results = statement.executeQuery()) {
                while (results.next()) {
                    String productName = results.getString("ProductName");
                    int totalQuantity = results.getInt("Total");

                    CustomerOrderHistory orderHistory = new CustomerOrderHistory(productName, totalQuantity);
                    orderHistoryList.add(orderHistory);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return orderHistoryList;
    }
}
