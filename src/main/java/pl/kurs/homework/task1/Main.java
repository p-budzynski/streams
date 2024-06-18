package pl.kurs.homework.task1;

import java.util.List;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {

        List<Double> doubleList = Stream.iterate(1.0, n -> n + 1).limit(1000)
                .filter(x -> x % 2 == 0)
                .map(x -> x / 2)
                .filter(x -> x % 2 == 0)
                .skip(50)
                .limit(100)
                .collect(Collectors.toList());

        System.out.println(doubleList);
    }
}
