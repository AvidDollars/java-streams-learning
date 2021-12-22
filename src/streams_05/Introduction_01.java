package streams_05;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Introduction_01 {
    public static void main(String[] args) {
        // streams are lazy:
        //      if terminal operation is not invoked ('collect' method),
        //      no data processing will occur, just stream pipeline will be defined
        //
        // Stream            vs.      Collection
        // -------------------------------------------
        // no storage         |       are containers
        // can be infinite    |       finite size
        // lazy evaluation    |       eager evaluation

        List<Integer> listOfInts = List.of(1, 2, 7, 12, 5, 4, 50, 49, 72, 88, 51);
        Predicate<Integer> oddNumbers = num -> num % 2 == 1;

        List<Integer> filteredList = getNumbersFilteredBy(listOfInts, oddNumbers);
        // filteredList → [1, 7, 5, 49, 51]
    }

    static List<Integer> getNumbersFilteredBy(List<Integer> list, Predicate<Integer> filter) {
        // 'stream' method lives in Collection interface
        // 'stream()' returns Stream interface object which has a few methods:
        //      e.g. filter / map / mapToInt / flatMap / sorted / limit / takeWhile ...
        //      all of them return Stream object when called


        // stream = data pipe
        return list.stream() // .stream() is responsible for iteration
                .filter(filter)
                // stream does not have its own storage
                // the result of stream has to be collected to some data structure
                // e.g. to a list:
                .collect(Collectors.toList());
    }
}
