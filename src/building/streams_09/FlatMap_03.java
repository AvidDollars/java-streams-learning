package building.streams_09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlatMap_03 {
    public static void main(String[] args) {
        // flatMap:
        //      maps one element to multiple elements → one-to-many mapping
        //      to flatten nested structure (= map() + flattening)
        //
        // <R> Stream<R> flatMap(Function<T, Stream<R>> mapper)

        // e.g.:
        var list = List.of(1, 2, 3);
        var newList = list.stream()
                .flatMap(number -> Stream.of(number * 10, number * 100))
                .collect(Collectors.toList());
        // newList; → [10, 100, 20, 200, 30, 300]

        int[][] nestedNumbers = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        int[] flatNumbers = Arrays.stream(nestedNumbers)
                .flatMapToInt(Arrays::stream)
                .toArray();
        // Arrays.toString(flatNumbers); → [1, 2, 3, ..., 9]

        // extracting words from a file
        List<String> words = null;

        try (Stream<String> lines = Files.lines(Paths.get("src/building/streams_09/words"))) {
            words = lines
                    .flatMap(l -> Arrays.stream(l.split("\\s+")))
                    .filter(word -> word.length() > 2)
                    .collect(Collectors.toList());

        } catch (IOException exception) {
            System.out.printf("Exception has occurred: %s", exception);
        }

        // words; → [hello, world, these, are, some, random, words, ...]
    }
}
