package pluralsight;

import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet results = null;

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

            connection = DriverManager.getConnection(
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

            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, lastNameToSearch);

            results = preparedStatement.executeQuery();

            while (results.next()) {
                /*String firstName = results.getString(1);
                String lastName = results.getString(2);*/

                String firstName = results.getString("first_name");
                String lastName = results.getString("last_name");

                System.out.println("FirstName: " + firstName);
                System.out.println("LastName: " + lastName);
                System.out.println("===========================================");
            }


        } catch (Exception ex) {
            System.out.println("An error has occurred!");
            ex.printStackTrace();
        } finally {
            if (results != null) {
                try {
                    results.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
