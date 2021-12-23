package collectors.api_08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DownstreamCollector_02 {
    public static void main(String[] args) {
        List<String> numberList = Arrays.asList(
                "hello", "World", "these", "are", "just", "randomly",
                "picked", "words", "to", "play", "with"
        );

        // counting size of groups after grouping strings based on its length
        Map<Integer, Long> lengthGroups = numberList.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        // downstream collector
                        Collectors.counting()
                ));

        // lengthGroups; → {2=1, 3=1, 4=3, 5=4, 6=1, 8=1}
    }
}
