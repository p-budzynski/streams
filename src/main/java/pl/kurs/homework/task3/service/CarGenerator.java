package pl.kurs.homework.task3.service;

import pl.kurs.homework.task3.model.Car;
import pl.kurs.homework.task3.model.Engine;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CarGenerator {
    private static final String PRODUCER = "BMW";
    private static final String[] BMW_MODELS = {"3", "4", "5", "7", "8", "X3", "X5", "X6", "X7"};
    private final Random random = new Random();

    public List<Car> generateCarsList(int amountCars) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < amountCars; i++) {
            cars.add(generateCar());
        }
        return cars;
    }

    private Car generateCar() {
        String producer = PRODUCER;
        String model = BMW_MODELS[random.nextInt(BMW_MODELS.length)];
        Engine engine = generateEngine();
        return new Car(producer, model, engine);
    }

    private Engine generateEngine() {
        int power = 200 + random.nextInt(401);
        int torque = 300 + random.nextInt(501);
        double displacement = roundToOneDecimalPlace(1.5 + (4.5 - 1.5) * random.nextDouble());
        String description = "Number of horses per liter of capacity: " + roundToOneDecimalPlace(power/displacement);
        return new Engine(power, torque, displacement, description);
    }

    private double roundToOneDecimalPlace(double value) {
        BigDecimal bigDecimal = new BigDecimal(value).setScale(1, RoundingMode.HALF_UP);
        return bigDecimal.doubleValue();
    }
}
