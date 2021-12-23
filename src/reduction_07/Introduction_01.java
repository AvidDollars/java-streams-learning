package reduction_07;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Introduction_01 {
    public static void main(String[] args) {
        // reduction
        // input: multiple elements, output: single element
        // methods:
        //      reduce, sum, count, min, max, allMatch, anyMatch, ...
        //      collect (mutable reduction)

        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numberArray)
                // int reduce(int identity, IntBinaryOperator op)
                // identity → initial value
                // Integer::sum → responsible for accumulation
                .reduce(0, Integer::sum); // or .sum()

        // sum; → 55

        List<String> wordsList = Arrays.asList(
                "Hello", "  this  ", "is",
                "some  ", "  words"
        );

        Function<String, String> removeEmptySpaces = string -> string.replace(" ", "");

        // e.g. sum length of all words but don't include empty spaces
        int characterCount = wordsList.stream()
                .map(removeEmptySpaces)
                // returns IntStream → stream for primitive ints
                .mapToInt(String::length)
                .sum(); // defined in 'IntStream' interface (because of invocation of 'mapToInt')

                // IntStream mapToInt(ToIntFunction<? super T> mapper) → primitive specialization of Stream
                // other → mapToLong / mapToDouble
                // reason to use: auto-boxing is costly operation

        // characterCount; → 20
    }
}
