package pl.kurs.homework.task5.model;

import java.util.Objects;

public abstract class Animal {
    private String name;
    private int age;
    private boolean sterilized;

    public Animal(String name, int age, boolean sterilized) {
        this.name = name;
        this.age = age;
        this.sterilized = sterilized;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isSterilized() {
        return sterilized;
    }

    public void setSterilized(boolean sterilized) {
        this.sterilized = sterilized;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return age == animal.age && sterilized == animal.sterilized && Objects.equals(name, animal.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, sterilized);
    }

    @Override
    public String toString() {
        return name + ", age: " + age + ", sterilized: " + sterilized;
    }
}
