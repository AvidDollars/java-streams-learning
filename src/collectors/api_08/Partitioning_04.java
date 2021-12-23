package collectors.api_08;

import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static collectors.api_08.DownstreamCollector_03.getPeople;

public class Partitioning_04 {
    public static void main(String[] args) {
        // partitioning data based on some predicate

        List<Person> listOfPersons = getPeople();

        Predicate<Person> ifYoung = person -> person.getAge() < 20;

        Map<Boolean, List<Person>> ifYoungGroups = listOfPersons.stream()
                // achievable also with 'groupingBy'
                // but instead of predicate we need define function
                // e.g. Function<Person, Boolean> ifYoung = person -> person.getAge() < 20;
                .collect(Collectors.partitioningBy(ifYoung));

        // ifYoungGroups; → {false=[Person{name='Nick', age=22, gender=MALE}, ... }

    }
}
