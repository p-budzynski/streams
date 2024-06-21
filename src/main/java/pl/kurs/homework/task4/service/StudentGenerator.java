package pl.kurs.homework.task4.service;

import pl.kurs.homework.task4.model.BehaviorGrade;
import pl.kurs.homework.task4.model.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StudentGenerator {
    private static final String[] FIRST_NAMES = {"John", "Anna", "Peter", "Kate", "Thomas", "Mary", "Agnes", "Paul", "Andrew"};
    private static final String[] LAST_NAMES = {"Smith", "Johnson", "Williams", "Jones", "Martinez", "Davis", "Brown", "lopez"};
    private final Random random = new Random();

    public List<Student> generateStudentsList(int amountStudents) {
        List<Student> students = new ArrayList<>();
        for (int i = 0; i < amountStudents; i++) {
            students.add(generateStudent());
        }
        return students;
    }

    private Student generateStudent() {
        String firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        String lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        int yearOfBrith = 2008 + random.nextInt(10);
        BehaviorGrade behaviorGrade = BehaviorGrade.values()[random.nextInt(BehaviorGrade.values().length)];
        return new Student(firstName, lastName, yearOfBrith, behaviorGrade);
    }
}
