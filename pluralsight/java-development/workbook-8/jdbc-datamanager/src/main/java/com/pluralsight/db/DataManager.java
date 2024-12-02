package com.pluralsight.db;

import com.pluralsight.models.Product;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DataManager {
    private DataSource dataSource;

    public DataManager(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
        String productsQuery = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productsQuery);
             ResultSet results = preparedStatement.executeQuery()) {

            while (results.next()) {
                int productId = results.getInt(1);
                String productName = results.getString(2);
                double unitPrice = results.getDouble(3);
                int unitsInStock = results.getInt(4);

                Product product = new Product(productId, productName, unitPrice, unitsInStock);
                products.add(product);
            }

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
        return products;
    }

    public Product getProductById(int productId) {
        String productByIdQuery = "SELECT ProductID, ProductName, UnitPrice, UnitsInStock FROM products WHERE ProductID = ?";
        Product product = null;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(productByIdQuery)) {
            preparedStatement.setInt(1, productId);

            try (ResultSet results = preparedStatement.executeQuery()) {
                if (results.next()) {
                    int productIdFromDb = results.getInt(1);
                    String productName = results.getString(2);
                    double unitPrice = results.getDouble(3);
                    int unitsInStock = results.getInt(4);

                    product = new Product(productIdFromDb, productName, unitPrice, unitsInStock);
                } else {
                    System.out.println("Product not found!");
                }
            }

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }

        return product;
    }
}
