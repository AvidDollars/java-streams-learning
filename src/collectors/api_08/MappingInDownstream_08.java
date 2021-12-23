package collectors.api_08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static collectors.api_08.DownstreamCollector_03.getPeople;

public class MappingInDownstream_08 {
    public static void main(String[] args) {
        List<Person> personList = getPeople();

        // e.g. we want to list all names for each gender
        Map<Gender, List<String>> namesGroupedByGender = personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender, // make group for each gender
                        Collectors.mapping(
                                Person::getName, // extract names
                                Collectors.toList() // put those names into list
                        )
                ));

        // namesGroupedByGender; → {MALE=[Nick, Jack, Jimi, Peter, Robert, ... }
    }
}
