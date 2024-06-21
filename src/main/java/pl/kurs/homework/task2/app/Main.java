package pl.kurs.homework.task2.app;

import pl.kurs.homework.task2.model.Employee;
import pl.kurs.homework.task2.service.EmployeeGenerator;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        EmployeeGenerator generator = new EmployeeGenerator();

        List<Employee> employees = generator.generateEmployeesList(1000);

        LinkedHashSet<Employee> processedEmployees = employees.stream()
                .filter(employee -> employee.getSalary() <= 10000.0)
                .peek(employee -> employee.setSalary((int) (employee.getSalary() * 1.2)))
                .distinct()
                .sorted(Comparator.comparing(Employee::getSalary).reversed()
                        .thenComparing(Employee::getLastName)
                        .thenComparing(Employee::getFirstName))
                .collect(Collectors.toCollection(LinkedHashSet::new));

        System.out.println("Number of processed employees: " + processedEmployees.stream()
                .count());

        processedEmployees
                .forEach(System.out::println);

    }
}