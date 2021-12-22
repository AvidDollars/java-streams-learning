package reduction_07;

import java.util.Arrays;

public class Introduction_01 {
    public static void main(String[] args) {
        // reduction
        // input: multiple elements, output: single element
        // methods:
        //      reduce, sum, count, min, max, allMatch, anyMatch, ...

        int[] numberArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int sum = Arrays.stream(numberArray)
                // int reduce(int identity, IntBinaryOperator op)
                // identity → initial value
                // Integer::sum → responsible for accumulation
                .reduce(0, Integer::sum); // or .sum()

        // sum; → 55
    }
}
