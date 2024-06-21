package pl.kurs.homework.task4.model;

import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private int yearOfBirth;
    private BehaviorGrade behaviorGrade;

    public Student(String firstName, String lastName, int yearOfBirth, BehaviorGrade behaviorGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearOfBirth = yearOfBirth;
        this.behaviorGrade = behaviorGrade;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }

    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public BehaviorGrade getBehaviorGrade() {
        return behaviorGrade;
    }

    public void setBehaviorGrade(BehaviorGrade behaviorGrade) {
        this.behaviorGrade = behaviorGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfBirth == student.yearOfBirth && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && behaviorGrade == student.behaviorGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, yearOfBirth, behaviorGrade);
    }

    @Override
    public String toString() {
        return "Student: " + firstName + ", " + lastName + ", year of birth: " + yearOfBirth +
                ", behavior grade: " + behaviorGrade;
    }
}
