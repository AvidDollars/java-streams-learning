package streams_05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StatefulAndStatelessOperations_06 {
    public static void main(String[] args) {
        // intermediate operations:
        //      - stateful → sorted, distinct
        //          - depend on previous elements from a stream
        //      - stateless → filter, map
        //          - elements processed independently
        //
        // stream.peek():
        //      - basically just for debugging purposes
        //      - to see the elements as they flow past a certain point in a pipeline

        List<String> words = Arrays.asList(
                "hello", "World", "just", "some", "randomly",
                "chosen", "words", "To", "Play", "with", "while",
                "learning", "streams"
        );

        words.stream()
                .peek(item -> System.out.printf("current item: %s\n", item))
                // needs to be invoked in order to see 'peek' in action
                .collect(Collectors.toList());

        List<Integer> numberList = Arrays.asList(2, 5, 7, 4, 7, 1, 2, 0, 8, 10);
        List<Integer> processedNumbers = numberList.stream()
                // 'filter' is stateless operation:
                //      all elements go through filter one by one
                .filter(num -> num > 5)
                // all elements come up to 'sorted' and they stop at this point
                // because 'sorted' is stateful operation → data are buffered
                .sorted()
                .collect(Collectors.toList());

        System.out.println(processedNumbers);

    }
}
