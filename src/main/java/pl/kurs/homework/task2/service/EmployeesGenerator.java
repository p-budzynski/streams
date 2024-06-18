package pl.kurs.homework.task2.service;

import pl.kurs.homework.task2.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EmployeesGenerator {
    private static final String[] MEN_NAMES = {"Jan", "Piotr", "Łukasz", "Krzysztof", "Adam", "Robert"};
    private static final String[] WOMEN_NAMES = {"Maria", "Ewa", "Anna", "Dorota", "Karolina", "Agnieszka"};
    private static final String[] MEN_SURNAMES = {"Kowalski", "Nowakowski", "Wójcik", "Wiśniewski", "Barański", "Dąbrowski"};
    private static final String[] WOMEN_SURNAMES = {"Kowalska", "Nowakowska", "Wójcik", "Wiśniewska", "Barańska", "Dąbrowska"};
    private static final Random RANDOM = new Random();

    private Employee generateEmployee() {
        int gender = RANDOM.nextInt(2);
        String firstName;
        String lastName;
        if (gender == 0) {
            firstName = MEN_NAMES[RANDOM.nextInt(MEN_NAMES.length)];
            lastName = MEN_SURNAMES[RANDOM.nextInt(MEN_SURNAMES.length)];
        } else {
            firstName = WOMEN_NAMES[RANDOM.nextInt(WOMEN_NAMES.length)];
            lastName = WOMEN_SURNAMES[RANDOM.nextInt(WOMEN_SURNAMES.length)];
        }
        int salary = RANDOM.nextInt(15001) + 5000;

        return new Employee(firstName, lastName, salary);
    }

    public List<Employee> generateEmployeesList(int amountEmployee) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < amountEmployee; i++) {
            employees.add(generateEmployee());
        }
        return employees;
    }
}
