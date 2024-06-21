package pl.kurs.homework.task3.model;

import java.util.Objects;

public class Engine {
    private int power;
    private int torque;
    private double displacement;
    private String description;

    public Engine(int power, int torque, double displacement, String description) {
        this.power = power;
        this.torque = torque;
        this.displacement = displacement;
        this.description = description;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getTorque() {
        return torque;
    }

    public void setTorque(int torque) {
        this.torque = torque;
    }

    public double getDisplacement() {
        return displacement;
    }

    public void setDisplacement(double displacement) {
        this.displacement = displacement;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Engine engine = (Engine) o;
        return power == engine.power && torque == engine.torque && Double.compare(displacement, engine.displacement) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(power, torque, displacement);
    }

    @Override
    public String toString() {
        return "power: " + power + " KM, torque: " + torque + " Nm, displacement: " + displacement + " l, " + description;
    }
}
