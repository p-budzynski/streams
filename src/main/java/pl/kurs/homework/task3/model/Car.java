package pl.kurs.homework.task3.model;

import java.util.Objects;

public class Car {
    private String producer;
    private String model;
    private Engine engine;

    public Car(String producer, String model, Engine engine) {
        this.producer = producer;
        this.model = model;
        this.engine = engine;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(producer, car.producer) && Objects.equals(model, car.model) && Objects.equals(engine, car.engine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(producer, model, engine);
    }

    @Override
    public String toString() {
        return "Car: " + producer + " " + model + ", engine: " + engine;
    }
}
