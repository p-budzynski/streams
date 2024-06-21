package pl.kurs.homework.task4.app;

import pl.kurs.homework.task4.model.BehaviorGrade;
import pl.kurs.homework.task4.model.Student;
import pl.kurs.homework.task4.service.StudentGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StudentRunner {
    public static void main(String[] args) {
        StudentGenerator generator = new StudentGenerator();

        List<List<Student>> studentsLists = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            studentsLists.add(generator.generateStudentsList(20));
        }

        Map<Integer, Long> birthYearCounter = studentsLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Student::getYearOfBirth, Collectors.counting()));

        Integer mostCommonBirthYear = birthYearCounter.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();

        Integer leastCommonBirthYear = birthYearCounter.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow();

        System.out.println("Most common birth year: " + mostCommonBirthYear);
        System.out.println("Least common birth year: " + leastCommonBirthYear);

        Map<BehaviorGrade, Long> behaviorGradeCounter = studentsLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(Student::getBehaviorGrade, Collectors.counting()));

        behaviorGradeCounter.forEach(((behaviorGrade, count) ->
                System.out.println("Number of student with behavior grade " + behaviorGrade + ": " + count)));

        Map<String, Long> nameCounter = studentsLists.stream()
                .flatMap(List::stream)
                .collect(Collectors.groupingBy(student -> student.getFirstName() + " " + student.getLastName(), Collectors.counting()));

        long studentsWithTheSameName = nameCounter.values().stream()
                .filter(aLong -> aLong > 1)
                .mapToLong(Long::longValue)
                .sum();

        System.out.println("Students with the same first and last name: " + studentsWithTheSameName);
    }
}
