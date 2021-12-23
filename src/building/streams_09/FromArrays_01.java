package building.streams_09;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FromArrays_01 {
    public static void main(String[] args) {
        // stream can be build from various sources:
        // - values → Stream.of(1, 2, 3)
        // - arrays → Arrays.stream(array)
        // - files → Files.lines(path, charset)
        // - infinite streams → Stream.iterate / Stream.generate

        int[] numbers = IntStream.rangeClosed(0, 10).toArray();
        // Arrays.toString(numbers); → [0, 1, 2, ..., 10]

        int[] numbersTwo = IntStream.range(0, 10).toArray();
        // Arrays.toString(numbersTwo); → [0, 1, 2, ..., 9]

        int[] evenNumbers = IntStream.of(2, 4, 6, 8, 10).toArray();
        // Arrays.toString(evenNumbers); → [2, 4, 6, 8, 10]

        String[] names = {"Jack", "John", "Emily", "Suzan"};
        String filteredNames =  Arrays.stream(names)
                .filter(name -> name.startsWith("J"))
                .collect(Collectors.joining());
        // filteredNames; → JackJohn
    }
}
