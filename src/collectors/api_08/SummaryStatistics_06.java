package collectors.api_08;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static collectors.api_08.DownstreamCollector_03.getPeople;

public class SummaryStatistics_06 {
    public static void main(String[] args) {
        List<Person> listOfPersons = getPeople();

        Map<Gender, IntSummaryStatistics> genderStatistics = listOfPersons.stream()
                .collect(Collectors.groupingBy(
                        Person::getGender,
                        // statistics for age field for each gender
                        Collectors.summarizingInt(Person::getAge)
                ));

        // genderStatistics; → {MALE=IntSummaryStatistics{count=6, sum=96, min=10, average=16,000000 ... }
    }
}
