package collectors.api_08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static collectors.api_08.DownstreamCollector_03.getPeople;

public class Grouping_01 {
    public static void main(String[] args) {
        // group data based on some criterion
        // Collector<T, Map<K, List<T>>> groupingBy(Function<T,K> classifier)

        List<String> numberList = Arrays.asList(
                "hello", "World", "these", "are", "just", "randomly",
                "picked", "words", "to", "play", "with"
        );

        // grouping based on length of a string
        Map<Integer, List<String>> lengthGroups = numberList.stream()
                .collect(Collectors.groupingBy(String::length));

        // lengthGroups; → {2=[to], 3=[are], 4=[just, play, ...


        // e.g. separation to multiple age fractions
        List<Person> listOfPersons = getPeople();

        Map<String, List<Person>> ageFractions = listOfPersons.stream()
                .collect(Collectors.groupingBy(Grouping_01::getAgeGroup));

        // ageFractions; →{middle=[Person{name='Nick', age=22, gender=MALE}, ... }
    }

    static String getAgeGroup(Person person) {
        return (person.getAge() < 20)
                ? "young"
                : (person.getAge() > 60)
                    ? "old"
                    : "middle";
    }
}
