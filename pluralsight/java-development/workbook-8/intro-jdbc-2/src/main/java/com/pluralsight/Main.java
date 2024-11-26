package com.pluralsight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            if (args.length != 2) {
                System.out.println("The application needs a Username and Password to run");
                System.exit(1);
            }

            String username = args[0];
            String password = args[1];

            Scanner scanner = new Scanner(System.in);
            System.out.println("Please enter the last name of the customer you want to search:");
            String lastNameToSearch = scanner.nextLine();

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/sakila",
                    username,
                    password
            );

            String query = """
                    SELECT first_name, last_name
                    FROM customer
                    WHERE last_name LIKE ?
                    ORDER BY first_name;
                    """;

            PreparedStatement preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, lastNameToSearch);

            ResultSet results = preparedStatement.executeQuery();

            while (results.next()) {
                /*String firstName = results.getString(1);
                String lastName = results.getString(2);*/

                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");

                System.out.println("FirstName: " + firstName);
                System.out.println("LastName: " + lastName);
                System.out.println("===========================================");
            }

            results.close();
            preparedStatement.close();
            connection.close();

            scanner.close();

        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        }
    }
}
