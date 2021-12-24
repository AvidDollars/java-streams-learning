package examples_11;

import java.util.Map;
import java.util.stream.Collectors;

public class IteratingOverMap_02 {
    public static void main(String[] args) {
        var dictionary = Map.of(
                "hello", 5, "world", 10, "mapping", 10,
                "example", 20, "some", 1, "very", 100,
                "random", 10, "words", 50, "yeah", 5
        );

        var wordList = dictionary.entrySet().stream()
                .filter(entry -> entry.getValue() == 10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        // wordList; → [random, world, mapping]

    }
}