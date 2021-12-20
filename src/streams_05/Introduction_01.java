package streams_05;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Introduction_01 {
    public static void main(String[] args) {
        List<Integer> listOfInts = List.of(1, 2, 7, 12, 5, 4, 50, 49, 72, 88, 51);
        Predicate<Integer> oddNumbers = num -> num % 2 == 1;

        List<Integer> filteredList = getNumbersFilteredBy(listOfInts, oddNumbers);
        // filteredList → [1, 7, 5, 49, 51]
    }

    static List<Integer> getNumbersFilteredBy(List<Integer> list, Predicate<Integer> filter) {
        // pipeline of function calls
        return list.stream() // .stream() is responsible for iteration
                .filter(filter)
                .collect(Collectors.toList()); // result of iteration with a filter is placed into list
    }
}
