package examples_11;

import java.util.Map;
import java.util.stream.Collectors;

public class CountCharactersInString_01 {
    public static void main(String[] args) {
        String text = "Hello, world!";

        // returns IntStream
        Map<Character, Long> counter = text.chars()
                // number → character (e.g. 72 → H)
                .mapToObj(number -> (char)number)
                .filter(character -> character.toString().matches("[A-Za-z]"))
                .collect(Collectors.groupingBy(
                        // or 'Function.identity()
                        character -> character,
                        Collectors.counting())
                );
        System.out.println(counter);
    }
}
