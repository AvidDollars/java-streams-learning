package streams_05;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Map_02 {
    public static void main(String[] args) {
        List<String> wordList = List.of(
                "Hello", "world", "just", "some", "randomly",
                "picked", "words", "to", "play", "with", "while",
                "learning", "streams"
        );

        // map → responsible for transformation of data
        // e.g. string → upper-case string
        List<String> capsLock = transformElementsBy(wordList, String::toUpperCase);
        // capsLock → [HELLO, WORLD, JUST, SOME, RANDOMLY, ...]
    }

    static List<String> transformElementsBy(List<String> list, Function<String, String> transformer) {
        return list.stream()
                // takes a Function object as an argument
                .map(transformer)
                .collect(Collectors.toList());
    }
}
