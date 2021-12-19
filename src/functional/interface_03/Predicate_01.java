package functional.interface_03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

public class Predicate_01 {
    public static void main(String[] args) {

        // Predicate functional interface has only one abstract method → test(Object)
        // basically just a filter
        Predicate<Integer> numberLessThanTen = number -> number < 10;
        Predicate<Integer> numberIsEven = number -> number % 2 == 0;

        List<Integer> numberList = Arrays.asList(3, 5, 7, 9, 11, 13, 15);
        getNumbersFilteredBy(numberList, numberLessThanTen); // [3, 5, 7, 9]

        // predicates can be chained with 'and' | 'or' | 'negate' default methods
        // default method → method is implemented straight inside interface
        Predicate<Integer> lessThanTenAndOdd = numberLessThanTen.and(numberIsEven);
        getNumbersFilteredBy(numberList, lessThanTenAndOdd); // []

        // other predicate interface:
        // predicate interfaces for primitive types → IntPredicate, LongPredicate, DoublePredicate
        // predicate accepting 2 arguments → BiPredicate
    }

    public static List<Integer> getNumbersFilteredBy(List<Integer> numbers, Predicate<Integer> filter) {
        List<Integer> filteredNumbers = new ArrayList<>();

        for (Integer number: numbers) {
            if (filter.test(number)) {
                filteredNumbers.add(number);
            }
        }

        return filteredNumbers;
    }
}
