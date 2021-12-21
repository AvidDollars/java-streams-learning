package streams_05;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Distinct_05 {
    public static void main(String[] args) {
        // distinct() → returns stream made of unique elements
        //      - uniqueness is evaluated with 'equals' method
        //      - uses HashSet behind the scenes to retrieve unique elements

        Predicate<Integer> evenNumber = number -> number % 2 == 0;

        List<Integer> listOfInts = List.of(2, 5, 7, 7, 4, 12, 5, 2, 4);

        List<Integer> uniqueInts = listOfInts.stream()
                .filter(evenNumber)
                .distinct()
                .collect(Collectors.toList());

        // uniqueInts; → [2, 4, 12]

        List<Person> personList = List.of(
                new Person("Michael", 15), new Person("Jack", 12),
                new Person("Jack", 12), new Person("Anabel", 15),
                new Person("Adam", 14), new Person("Samuel", 22),
                new Person("Viktor", 20), new Person("Edvard", 15),
                new Person("Edvard", 19), new Person("Adam", 14)
        );

        // we want to return all unique persons (unique combination of name and age)
        // to do that → we have to override 'equals' method in Person class
        List<Person> uniquePersons = personList.stream()
                .distinct()
                .collect(Collectors.toList());

        // uniquePersons.size(); → 8
        //
        // if 'equals' method in Person class is not overridden:
        //      uniquePersons.size(); → 10
    }
}