package optional.api_06;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class FindAny_04 {
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(
                1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15
        );

        Optional filteredNumbers = numberList.stream()
                .filter(FindAny_04::numDivisibleBy2and3)
                // returns 'Optional' object (with a match or empty)
                // short-circuiting terminal operation
                // does not guarantee to return first match (it is free to select any matching element)
                .findAny();

        // filteredNumbers; → Optional[6]
    }

    static boolean numDivisibleBy2and3(int number) {
        return number % 2 == 0 && number % 3 == 0;
    }
}
