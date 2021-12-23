package streams_05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ForEach_08 {
    public static void main(String[] args) {
        // 'forEach' → terminal operation
        // use cases → printing elements / processing elements individually

        // forEach anti-pattern:
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> evenNumbers = new ArrayList<>();

        numbers.stream()
                .filter(number -> number % 2 == 0)
                .forEach(evenNumbers::add);

        // evenNumbers; → [2, 4, 6, 8, 10]
        // use 'collect' instead
    }
}
