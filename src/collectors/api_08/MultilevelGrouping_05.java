package collectors.api_08;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static collectors.api_08.DownstreamCollector_03.getPeople;

public class MultilevelGrouping_05 {
    public static void main(String[] args) {
        // 'groupingBy' can take Collector as 2nd argument
        // so that we can build nested groups

        List<Person> listOfPersons = getPeople();

        Map<Gender, Map<String, List<Person>>> groups = listOfPersons.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        Collectors.groupingBy(Grouping_01::getAgeGroup)
                ));

        // groups; → {MALE={middle=[Person{name='Nick', age=22, gender=MALE}, Person ... }
    }
}
