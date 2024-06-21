package pl.kurs.homework.task5.app;

import pl.kurs.homework.task5.model.Animal;
import pl.kurs.homework.task5.model.Cat;
import pl.kurs.homework.task5.model.Dog;
import pl.kurs.homework.task5.service.AnimalGenerator;

import java.util.Comparator;
import java.util.List;

public class AnimalRunner {
    public static void main(String[] args) {
        AnimalGenerator generator = new AnimalGenerator();

        List<Animal> animals = generator.generateAnimalsList(100);

        long catsCount = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .count();

        System.out.println("Number of cats: " + catsCount);

        long unsterilizedCats = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .filter(cat -> !cat.isSterilized())
                .peek(cat -> cat.setSterilized(true))
                .count();

        System.out.println("Number of unsterilized cats before sterilization: " + unsterilizedCats);

        long dogsCount = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .count();

        System.out.println("Number of dogs: " + dogsCount);

        long dogsUnsterilized = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .filter(dog -> !dog.isSterilized())
                .peek(dog -> dog.setSterilized(true))
                .count();

        System.out.println("Number of unsterilized dogs before sterilization: " + dogsUnsterilized);

        Cat oldestCat = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .map(animal -> (Cat) animal)
                .max(Comparator.comparingInt(Cat::getAge))
                .orElse(null);

        if (oldestCat != null) {
            System.out.println("The oldest cat: " + oldestCat);
        }

        Dog oldestDog = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .map(animal -> (Dog) animal)
                .max(Comparator.comparingInt(Dog::getAge))
                .orElse(null);

        if (oldestDog != null) {
            System.out.println("The oldest dog: " + oldestDog);
        }

        Cat youngestCat = animals.stream()
                .filter(animal -> animal instanceof Cat)
                .map(animal -> (Cat) animal)
                .min(Comparator.comparingInt(Cat::getAge))
                .orElse(null);

        if (youngestCat != null) {
            System.out.println("The youngest cat: " + youngestCat);
        }

        Dog youngestDog = animals.stream()
                .filter(animal -> animal instanceof Dog)
                .map(animal -> (Dog) animal)
                .min(Comparator.comparingInt(Dog::getAge))
                .orElse(null);

        if (youngestDog != null) {
            System.out.println("The youngest dog: " + youngestDog);
        }

        if (oldestCat != null && youngestDog != null) {
            int yearsDifference = oldestCat.getAge() - youngestDog.getAge();
            System.out.println("Year difference between the oldest cat and the youngest dog: " + yearsDifference);
        }

    }
}
