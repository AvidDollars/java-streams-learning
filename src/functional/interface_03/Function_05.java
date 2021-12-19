package functional.interface_03;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToIntFunction;

public class Function_05 {
    public static void main(String[] args) {
        // one abstract method in Function interface:
        // takes argument of type T and returns a value of type R → R apply(T t)
        // two default methods in Function interface:
        //      - default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
        //      - default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
        //
        // x -> b.apply(a.apply(x)) == a.andThen(b) == b.compose(a)

        List<Integer> lengthsOfStrings = new ArrayList<>();
        List<String> listOfStrings = List.of(
                "hello", "world", "this", "is",
                "just", "some", "random", "words"
        );

        // performance issue: String::length returns int, stringLength returns Integer
        // int is being boxed into Integer
        Function<String, Integer> stringLength = String::length;

        // no auto-boxing, int is returned (abstract method = applyAsInt)
        ToIntFunction<String> stringLengthTwo = String::length;

        for (String str: listOfStrings) {
            int length = stringLength.apply(str);
            lengthsOfStrings.add(length);
        }

        // finding max value in a list
        List<Integer> numberList = List.of(5, 2, 7, 12, 5, 9, 4, 1, 52, 7, 2, 8);
        ToIntFunction<List<Integer>> findMax = Function_05::maxValueInList;
        findMax.applyAsInt(numberList); // 52
    }

    static int maxValueInList(List<Integer> list) {
        int max = Integer.MIN_VALUE;
        for (Integer number: list) {
            if (number > max) {
                max = number;
            }
        }
        return max;
    }
}
