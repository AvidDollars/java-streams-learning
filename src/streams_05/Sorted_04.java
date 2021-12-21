package streams_05;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Sorted_04 {
    public static void main(String[] args) {
        // Stream<T> sorted():
        //      if no argument is provided,
        //      sorting will be done on basis of natural sorting order of elements
        //      (an object must implement Comparable interface)
        //
        // Stream<T> sorted(Comparator<? super T> comparator)
        //      sorting based on the output from a comparator

        List<String> wordsList = Arrays.asList(
                "hello", "World", "these", "are", "Just",
                "some", "randomly", null, "picked", "words", "that",
                "will", "Be", "used", "for", "stream", "operation"
        );

        Comparator<String> byLastCharacter = Comparator.comparing(
                word -> word.length() > 1 ? word.substring(word.length() - 1) : ""
        );

        List<String> processedWords = wordsList.stream()
                // catching NullPointerException if an item is null
                .filter(Objects::nonNull)
                .filter(word -> word.length() > 3)
                .filter(word -> !word.matches("[tA-Z]\\w*"))

                // would be ok not to provide any argument,
                // because String class implements Comparable<String> interface
                .sorted(byLastCharacter) // will not mutate original list
                .collect(Collectors.toList());

        // processedWords → [picked, used, some, will, stream, ...]
    }
}
