package com.pluralsight;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee("Ray", "Maroun", 55));
        employees.add(new Employee("Brandon", "Johnson", 35));
        employees.add(new Employee("Emre", "Akarsu", 45));

        String lastNameToSearch = "Maroun";


/*        List<Employee> matchingEmployees = new ArrayList<>();

        for (Employee employee : employees) {
            if (employee.getLastName().equalsIgnoreCase(lastNameToSearch)) {
                matchingEmployees.add(employee);
            }
        }*/

        /*List<Employee> matchingEmployees =
                employees // Source - Data At Rest
                        .stream().filter(employee -> employee.getLastName().equalsIgnoreCase(lastNameToSearch)) // Data Transformation - Data is in Transit
                        .collect(Collectors.toList()); // Destination - Data At Rest*/


        ArrayList<Employee> matchingEmployees =
                employees // Source - Data At Rest
                        .stream().filter(employee -> employee.getLastName().equalsIgnoreCase(lastNameToSearch)) // Data Transformation - Data is in Transit
                        .collect(Collectors.toCollection(ArrayList::new)); // Destination - Data At Rest

        System.out.println("The results are: ");

        /*for (Employee matchingEmployee : matchingEmployees) {
            System.out.println(matchingEmployee);
        }*/

        matchingEmployees.forEach(matchingEmployee -> System.out.println(matchingEmployee));

    }
}
