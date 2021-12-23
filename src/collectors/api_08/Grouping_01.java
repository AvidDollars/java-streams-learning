package collectors.api_08;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Grouping_01 {
    public static void main(String[] args) {
        // group data based on some criterion
        // Collector<T, Map<K, List<T>>> groupingBy(Function<T,K> classifier)

        List<String> numberList = Arrays.asList(
                "hello", "World", "these", "are", "just", "randomly",
                "picked", "words", "to", "play", "with"
        );

        // grouping base on length of a string
        Map<Integer, List<String>> lengthGroups = numberList.stream()
                .collect(Collectors.groupingBy(String::length));

        // lengthGroups; → {2=[to], 3=[are], 4=[just, play, ...
    }
}
