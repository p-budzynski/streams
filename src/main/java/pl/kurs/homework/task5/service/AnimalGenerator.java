package pl.kurs.homework.task5.service;

import pl.kurs.homework.task5.model.Animal;
import pl.kurs.homework.task5.model.Cat;
import pl.kurs.homework.task5.model.Dog;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AnimalGenerator {
    private static final String[] NAME = {"Burek", "Luna", "Fafik", "Klusek", "Pyza", "Max", "Mia", "Rex", "Rambo", "Koko"};
    private final Random random = new Random();

    public List<Animal> generateAnimalsList(int numberAnimals) {
        List<Animal> animals = new ArrayList<>();
        for (int i = 0; i < numberAnimals; i++) {
            animals.add(generateAnimal());
        }
        return animals;
    }

    private Animal generateAnimal() {
        String name = NAME[random.nextInt(NAME.length)];
        int age = random.nextInt(15) + 1;
        boolean sterilized = random.nextBoolean();
        int num = random.nextInt(2);
        if (num == 0) {
            return new Cat(name, age, sterilized);
        } else {
            return new Dog(name, age, sterilized);
        }
    }
}
