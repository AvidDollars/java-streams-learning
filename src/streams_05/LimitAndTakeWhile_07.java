package streams_05;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LimitAndTakeWhile_07 {
    public static void main(String[] args) {
        // limit(long maxSize)
        // takeWhile(Predicate)
        //
        // both method return Stream object

        List<Integer> numberList = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
                11, 12, 13, 14, 15, 16, 17, 18
        );

        List<Integer> fiveOddNumbers = numberList.stream()
                .filter(number -> number % 2 == 1)
                .limit(5)
                .collect(Collectors.toList());
        // fiveOddNumbers; → [1, 3, 5, 7, 9]

        List<Integer> example = numberList.stream()
                // iterates until the predicate is evaluated to false
                .takeWhile(number -> number % 7 != 0)
                .collect(Collectors.toList());
        // example; → [1, 2, 3, 4, 5, 6]

        // both takeWhile and limit
        List<Integer> exampleBoth = numberList.stream()
                // iterates until the takeWhile predicate is evaluated to false
                // or maxSize in limit is not reached
                .takeWhile(number -> number % 10 != 0)
                .limit(5)
                .collect(Collectors.toList());
        // exampleBoth; → [1, 2, 3, 4, 5]
    }
}
