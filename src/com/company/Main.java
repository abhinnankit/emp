package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        try {
            Scanner input = new Scanner(new File("1000 Records.csv"));
            System.out.println(input.nextLine());
            while (input.hasNextLine()) {
                Scanner line = new Scanner(input.nextLine());
                line.useDelimiter(",");
                int id = line.nextInt();
                String name = line.next();
                int experience = line.nextInt();
                Employee employee = new Employee(id, name, experience);
                employeeList.add(employee);
            }
            Collections.sort(employeeList);
            employeeList.forEach(System.out::println);
//            for (Employee e: employeeList) {
//                System.out.println(e);
//            }
            do {
                System.out.println("Select an option");
                System.out.println("1. Search a name");
                System.out.println("2. Exit");
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                int answer = Integer.parseInt(in.readLine());
                if (answer == 2)
                    break;
                System.out.println("Enter the name to be searched");
                String searchText = in.readLine();
                int index = Employee.searchByName(employeeList, searchText);
                if (index < 0)
                    System.out.println("Not found");
                else
                    System.out.println("Found at " + index);
            } while (true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
