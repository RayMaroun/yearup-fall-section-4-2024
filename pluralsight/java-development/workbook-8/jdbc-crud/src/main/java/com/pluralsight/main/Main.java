package com.pluralsight.main;

import com.pluralsight.db.DataManager;
import org.apache.commons.dbcp2.BasicDataSource;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("User and Password are needed!");
            System.exit(1);
        }

        String username = args[0];
        String password = args[1];

        BasicDataSource sakilaDataSource = new BasicDataSource();
        sakilaDataSource.setUrl("jdbc:mysql://localhost:3306/sakila");
        sakilaDataSource.setUsername(username);
        sakilaDataSource.setPassword(password);

        DataManager dataManager = new DataManager(sakilaDataSource);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Insert Direct");
            System.out.println("2. Insert With Generated Keys");
            System.out.println("3. Update Record");
            System.out.println("4. Delete Record");
            System.out.println("5. Exit");
            System.out.println("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter a country name to insert: ");
                    String countryName = scanner.nextLine();
                    dataManager.insertIntoDirect(countryName);
                    break;
                case 2:
                    System.out.println("Enter a country name to insert: ");
                    String countryNameWithKey = scanner.nextLine();
                    dataManager.insertIntoWithGeneratedKeys(countryNameWithKey);
                    break;
                case 3:
                    System.out.println("Enter a new description: ");
                    String newDescription = scanner.nextLine();

                    System.out.println("Enter the ID of the film you want to update: ");
                    int filmId = scanner.nextInt();
                    scanner.nextLine();
                    dataManager.updateRecord(newDescription, filmId);
                    break;
                case 4:
                    System.out.println("Enter the country name to delete: ");
                    String countryToDelete = scanner.nextLine();
                    dataManager.deleteRecord(countryToDelete);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice. Please try again.");
            }
        }
    }
}
