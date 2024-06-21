package pl.kurs.homework.task3.app;

import pl.kurs.homework.task3.model.Car;
import pl.kurs.homework.task3.service.CarGenerator;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CarRunner {
    public static void main(String[] args) {
        CarGenerator generator = new CarGenerator();

        List<Car> carsList = generator.generateCarsList(100);

        List<Car> filteredCars = carsList.stream()
                .filter(car -> car.getEngine().getPower() > 300 && car.getEngine().getDisplacement() >= 2.0 && car.getEngine().getDisplacement() <= 4.0)
                .distinct()
                .collect(Collectors.toList());

        Car mostEfficientCar = filteredCars.stream()
                .max(Comparator.comparingDouble(car -> car.getEngine().getPower() / car.getEngine().getDisplacement()))
                .orElse(null);

        if (mostEfficientCar != null) {
            System.out.println("The car with the most effective engine: " + mostEfficientCar);
        }
    }
}
