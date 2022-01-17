package examples_11;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsExamples_05 {
    public static void main(String[] args) {
        // will work only if keys are unique
        // getNameAgeMap(Person.getPersonStreamSample());

        // we can collect values to unmodifiable list
        var allAges = getAllAges(Person.getPersonStreamSample());
        // allAges → [20, 22, 20, 32, 32, 3, 72, 11]

        var namesAbove30 = joinNamesOlderThan30(Person.getPersonStreamSample());
        // namesAbove30; → "Paula, Paul, Jack"

        var ageByName = groupAgesByName(Person.getPersonStreamSample());
        // ageByName; → {Bob=[20], Sara=[20, 22], ...

        // to count occurrences for each name → use ".counting" in ".groupingBy"
        Map<String, Long> nameCounter = Person.getPersonStreamSample()
                .collect(
                        Collectors.groupingBy(
                                Person::getName,
                                Collectors.counting()
                        )
                );
        // nameCounter → {Bob=1, Sara=2, Jill=1, Jack=2, Paula=1, Paul=1}

        // but what if you don't want to return "Long"? Use ".collectingAndThen"
        Map<String, Integer> nameCounterInt = Person.getPersonStreamSample()
                .collect(
                        Collectors.groupingBy(
                                Person::getName,
                                Collectors.collectingAndThen(
                                        Collectors.counting(),
                                        Long::intValue
                                )
                        )
                );
        // nameCounterInt; → {Bob=1, Sara=2, Jill=1, Jack=2, Paula=1, Paul=1}

    }

    public static Map<String, List<Integer>> groupAgesByName(Stream<Person> personStream) {
        return personStream
                .collect(
                        Collectors.groupingBy(
                                Person::getName,
                                // basically a map inside collector
                                // before putting person into a "bucket" name is extracted
                                Collectors.mapping(
                                        Person::getAge, Collectors.toList()
                                )
                        )
                );
    }

    public static Map<String, Integer> getNameAgeMap(Stream<Person> personStream) {
        return personStream.collect(
                Collectors.toMap(
                        Person::getName, // keyMapper
                        Person::getAge // valueMapper
                )
        );
    }

    public static List<Integer> getAllAges(Stream<Person> personStream) {
        return personStream
                .map(Person::getAge)
                // or we can use ".toUnmodifiableSet()"
                // or we can use ".toUnmodifiableMap()"
                .collect(Collectors.toUnmodifiableList());
    }

    public static String joinNamesOlderThan30(Stream<Person> personStream) {
        return personStream
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                // "prefix" and "suffix" can be provided as 2nd and 3rd argument respectively
                .collect(Collectors.joining(", "));
    }

}
