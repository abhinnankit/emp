package com.company;

import java.util.Collections;
import java.util.List;

public class Employee implements Comparable {
    private int id;
    private String name;
    private int experience;

    public Employee(int id, String name, int experience) {
        this.id = id;
        this.name = name;
        this.experience = experience;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public static int searchByName(List<Employee> employees, String name) {
        Collections.sort(employees);
        return binarySearchByName(employees, 0, employees.size() - 1, name);
    }

    private static int binarySearchByName(List<Employee> employees, int left, int right, String name) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            if (employees.get(mid).getName().compareTo(name) == 0)
                return mid;

            if (employees.get(mid).getName().compareTo(name) > 0)
                return binarySearchByName(employees, left, mid - 1, name);

            return binarySearchByName(employees, mid + 1, right, name);
        }

        return -1;
    }

    @Override
    public int compareTo(Object o) {
        return this.getName().compareTo(((Employee) o).getName());
    }

    @Override
    public String toString() {
        return this.id + " " + this.name + " " + this.experience;
    }

}
