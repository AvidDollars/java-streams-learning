package reduction_07;

import java.util.Arrays;
import java.util.Optional;

public class CountMaxMin_03 {
    public static void main(String[] args) {
        String[] words = {
                "hello", "world", "these", "are", "just", "some",
                "randomly", "picked", "words", "in", "order", "to",
                "perform", "operations", "using", "streams"
        };

        // .count() = .mapToLong(t -> 1L).sum()
        long wordCount = Arrays.stream(words)
                .filter(word -> word.length() == 5)
                .count();
        // wordCount; → 6

        // max / min:
        //      - input: Comparator, output: Optional
        //      - e.g.:
        Optional<String> word = Arrays.stream(words)
                // or 'Comparator.comparing(String::length)' → can be chained with 'thenComparing'
                .max((a, b) -> a.length() - b.length());
        // word; → Optional[operations]
    }
}
