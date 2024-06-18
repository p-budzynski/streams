package pl.kurs.homework.taskIndirectMethods;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class IndirectMethods {
    public static void main(String[] args) {

        // filter()

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        // map()

        List<String> fruits = Arrays.asList("banana", "apple", "orange", "strawberry", "watermelon", "pineapple");

        List<Integer> fruitsLength = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());

        // limit(n)

        List<Integer> limitedNumbers = numbers.stream()
                .limit(5)
                .collect(Collectors.toList());

        // distinct()

        List<Integer> numbersWithDuplicates = Arrays.asList(5, 5, 3, 7, 9, 8, 3, 0, 15, 24, 0, 22, 24);
        List<Integer> numbersWithoutDuplicates = numbersWithDuplicates.stream()
                .distinct()
                .collect(Collectors.toList());

        // sorted()

        List<String> names = Arrays.asList("Dariusz, Mariusz, Arkadiusz, Mateusz, Tymoteusz, Tadeusz, Janusz");
        List<String> sortedNames = names.stream()
                .sorted()
                .collect(Collectors.toList());

        // peek()

        List<String> upperCasedNames = names.stream()
                .peek(name -> System.out.println("Processing: " + name))
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        // skip(n)

        List<Integer> skippedNumbers = numbers.stream()
                .skip(5)
                .collect(Collectors.toList());

        // boxed()

        int[] numbers2 = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        List<Integer> boxedNumbers = Arrays.stream(numbers2)
                .boxed()
                .collect(Collectors.toList());

        // flatMap()

        List<List<String>> listOfNamesLists = Arrays.asList(
                Arrays.asList("Romeo", "Julia"),
                Arrays.asList("Bonnie", "Clyde"),
                Arrays.asList("Tarzan", "Jane")
        );

        List<String> flatList = listOfNamesLists.stream()
                .flatMap(Collection::stream)
                .collect(Collectors.toList());

    }
}
